package net.item.Custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Custom_Shovel extends Custom_Hummer {
    public TagKey<Block> tags = BlockTags.PICKAXE_MINEABLE;

    public Custom_Shovel(ToolMaterial material, TagKey<Block> blocksTag, Settings settings) {
        super(material, 1.5f, -3.0F, blocksTag, settings);
    }
    protected static final Map<Block, BlockState> PATH_STATES = Maps.newHashMap(
            new ImmutableMap.Builder<Block, BlockState>()
                    .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState())
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
                    itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }
            }
        }

        return ActionResult.success(world.isClient);
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
            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else if (state.getBlock() instanceof CampfireBlock && state.get(CampfireBlock.LIT)) {
            if (!world.isClient()) {
                world.syncWorldEvent(null, WorldEvents.FIRE_EXTINGUISHED, pos, 0);
            }
            CampfireBlock.extinguish(player, world, pos, state);
            return Optional.of(state.with(CampfireBlock.LIT, false));
        }
        return Optional.empty();
    }

    private Optional<BlockState> getFlattenedState(BlockState state) {
        return Optional.ofNullable(PATH_STATES.get(state.getBlock()));
    }
}
