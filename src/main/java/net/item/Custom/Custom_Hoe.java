package net.item.Custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Custom_Hoe extends Custom_Hummer {
    public Custom_Hoe(ToolMaterial material, TagKey<Block> blocksTag, Settings settings) {
        super(material, -1.0F, -2.0F, blocksTag, settings);
    }


    protected static final Map<Block, BlockState> PATH_STATES = Maps.newHashMap(
            new ImmutableMap.Builder<Block, BlockState>()
                    .put(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.MYCELIUM, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.DIRT_PATH, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.DIRT, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.COARSE_DIRT, Blocks.FARMLAND.getDefaultState())
                    .put(Blocks.ROOTED_DIRT, Blocks.DIRT.getDefaultState())
                    .build()
    );

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos initialBlockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();

        if (playerEntity == null) {return ActionResult.PASS;}

        boolean isSneaking = playerEntity.isSneaking();

        List<BlockPos> positions = isSneaking
                ? List.of(initialBlockPos)
                : getBlocksToBeDestroyed(initialBlockPos, playerEntity);

        BlockState targetState = world.getBlockState(initialBlockPos);
        if (targetState.getBlock() instanceof CropBlock) {
            return harvestCrops(world, positions, playerEntity);
        }

        for (BlockPos pos : positions) {
            BlockState state = world.getBlockState(pos);
            if (shouldCancelFlattenAttempt(context)) {
                return ActionResult.PASS;
            } else {
                Optional<BlockState> optional = this.tryFlatten(world, pos, playerEntity, state);
                if (optional.isEmpty()) {
                    continue;
                } else {
                    ItemStack itemStack = context.getStack();
                    if (playerEntity instanceof ServerPlayerEntity) {
                        Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, pos, itemStack);
                    }

                    world.setBlockState(pos, optional.get(), Block.NOTIFY_ALL_AND_REDRAW);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(playerEntity, optional.get()));

                    if (state.getBlock() == Blocks.ROOTED_DIRT && !world.isClient) {
                        Block.dropStack(world, pos, new ItemStack(Items.HANGING_ROOTS));
                    }

                    itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }
            }
        }

        return ActionResult.success(world.isClient);
    }

    private ActionResult harvestCrops(World world, List<BlockPos> positions, PlayerEntity player) {
        for (BlockPos pos : positions) {
            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if (block instanceof CropBlock cropBlock && cropBlock.isMature(state)) {
                if (!world.isClient) {
                    Block.dropStacks(state, world, pos);
                }

                world.setBlockState(pos, cropBlock.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                world.playSound(player, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        return ActionResult.SUCCESS;
    }

    private static boolean shouldCancelFlattenAttempt(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        if (!context.getHand().equals(Hand.MAIN_HAND)) return false;
        assert playerEntity != null;
        return playerEntity.getOffHandStack().isOf(Items.SHIELD) && !playerEntity.shouldCancelInteraction();
    }

    private Optional<BlockState> tryFlatten(World world, BlockPos pos, PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = getFlattenedState(state);
        if (optional.isPresent() && world.getBlockState(pos.up()).isAir()) {
            world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        }
        return Optional.empty();
    }

    private Optional<BlockState> getFlattenedState(BlockState state) {
        return Optional.ofNullable(PATH_STATES.get(state.getBlock()));
    }
}
