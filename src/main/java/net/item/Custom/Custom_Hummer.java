package net.item.Custom;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.util.CustomModComponents;

import java.util.ArrayList;
import java.util.List;

public class Custom_Hummer extends MiningToolItem {


    public int getSize(ItemStack stack) {
        return stack.get(CustomModComponents.SIZE);
    }

    public int getDeep(ItemStack stack) {
        return stack.get(CustomModComponents.DEEP);
    }

    public Custom_Hummer(ToolMaterial material,float damag,float speed, TagKey<Block> blocksTag, Settings settings) {
        super(material, blocksTag, settings.attributeModifiers(createAttributeModifiers(material, damag, speed)));
    }

    public Custom_Hummer(ToolMaterial material, TagKey<Block> blocksTag, Settings settings) {
        this(material,1.0F,-2.8F, blocksTag, settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, PlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {

            BlockHitResult blockHit = (BlockHitResult) hit;
            ItemStack heldItem = player.getMainHandStack();
            if (!(heldItem.getItem() instanceof Custom_Hummer tool)) return positions;

            int Size = tool.getSize(heldItem);
            int Deep = tool.getDeep(heldItem);

            Direction side = blockHit.getSide();

            if (side == Direction.UP || side == Direction.DOWN) {
                for (int x = -Size; x <= Size; x++)
                    for (int z = -Size; z <= Size; z++)
                        for (int y = 0; y <= Deep; y++) {
                            positions.add(initialBlockPos.add(x, side == Direction.UP ? -y : y, z));
                        }
            } else if (side == Direction.NORTH || side == Direction.SOUTH) {
                for (int x = -Size; x <= Size; x++)
                    for (int z = 0; z <= Deep; z++)
                        for (int y = -1; y <= Size * 2 - 1; y++) {
                            positions.add(initialBlockPos.add(x, y, side == Direction.NORTH ? z : -z));
                        }
            } else if (side == Direction.EAST || side == Direction.WEST) {
                for (int x = 0; x <= Deep; x++)
                    for (int z = -Size; z <= Size; z++)
                        for (int y = -1; y <= Size * 2 - 1; y++) {
                            positions.add(initialBlockPos.add(side == Direction.EAST ? -x : x, y, z));
                        }
            }
        }
        return positions;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        int size = getSize(stack);
        int deep = getDeep(stack);
        tooltip.add(Text.translatable("item.more_tools.size", (size * 2 + 1),(deep + 1)).formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
