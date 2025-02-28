package net.item.Custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Omni_tool extends MiningToolItem {
    protected static final Map<Block, BlockState> PATH_STATES = new ImmutableMap.Builder<Block, BlockState>()
                    .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState())
                    .put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState())
                    .build();

    protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS = Maps.<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>>newHashMap(
            ImmutableMap.of(
                    Blocks.GRASS_BLOCK,
                    Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                    Blocks.DIRT_PATH,
                    Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                    Blocks.DIRT,
                    Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                    Blocks.COARSE_DIRT,
                    Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.DIRT.getDefaultState())),
                    Blocks.ROOTED_DIRT,
                    Pair.of(itemUsageContext -> true, createTillAndDropAction(Blocks.DIRT.getDefaultState(), Items.HANGING_ROOTS))
            )
    );

    protected static final Map<Block, Block> STRIPPED_BLOCKS = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
            .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
            .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
            .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
            .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
            .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
            .put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG)
            .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
            .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
            .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
            .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
            .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
            .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
            .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
            .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
            .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
            .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
            .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
            .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG)
            .put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)
            .build();

    public Omni_tool(ToolMaterial material, TagKey<Block> blocksTag, Settings settings) {
        super(material, blocksTag, settings.attributeModifiers(createAttributeModifiers(material, 1F, -1.0F)));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        PlayerEntity player = context.getPlayer();

        // Лопатой можно делать дорожки
        if (context.getSide() != Direction.DOWN && PATH_STATES.containsKey(blockState.getBlock()) && world.getBlockState(blockPos.up()).isAir()) {
            world.playSound(player, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(blockPos, PATH_STATES.get(blockState.getBlock()), Block.NOTIFY_ALL_AND_REDRAW);
            assert player != null;
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            return ActionResult.SUCCESS;
        }

        // Мотыга обрабатывает землю
        Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> tillAction = TILLING_ACTIONS.get(blockState.getBlock());
        if (tillAction != null && tillAction.getFirst().test(context)) {
            world.playSound(player, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            tillAction.getSecond().accept(context);
            assert player != null;
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            return ActionResult.SUCCESS;
        }

        // Топор обдирает кору деревьев
        if (STRIPPED_BLOCKS.containsKey(blockState.getBlock())) {
            world.playSound(player, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

            BlockState newState = STRIPPED_BLOCKS.get(blockState.getBlock()).getDefaultState()
                    .with(Properties.AXIS, blockState.get(Properties.AXIS)); // Сохранение оси направления

            world.setBlockState(blockPos, newState, Block.NOTIFY_ALL_AND_REDRAW);
            assert player != null;
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    public static Consumer<ItemUsageContext> createTillAction(BlockState result) {
        return context -> context.getWorld().setBlockState(context.getBlockPos(), result, Block.NOTIFY_ALL_AND_REDRAW);
    }

    public static Consumer<ItemUsageContext> createTillAndDropAction(BlockState result, ItemConvertible drop) {
        return context -> {
            context.getWorld().setBlockState(context.getBlockPos(), result, Block.NOTIFY_ALL_AND_REDRAW);
            Block.dropStack(context.getWorld(), context.getBlockPos(), new ItemStack(drop));
        };
    }
}
