package net.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.item.CustomModItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(CustomModItem.STONE_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_BIG_SHOVEL_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.GOLDEN_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_BIG_SHOVEL_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_3, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.STONE_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_CLEAVER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.GOLDEN_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_CLEAVER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_CLEAVER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_CLEAVER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_CLEAVER_LVL_3, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.STONE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_HAMMER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.GOLDEN_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_HAMMER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_HAMMER_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_HAMMER_LVL_3, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.STONE_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_BIG_HOE_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.GOLDEN_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_BIG_HOE_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_HOE_LVL_2, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_BIG_HOE_LVL_3, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.STONE_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.IRON_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.GOLDEN_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.DIAMOND_OMNI_TOOL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.NETHERITE_OMNI_TOOL, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.COPPER_SWORD, Models.HANDHELD);

        itemModelGenerator.register(CustomModItem.AMETHYST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_AXE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_HOE, Models.HANDHELD);
        itemModelGenerator.register(CustomModItem.AMETHYST_SWORD, Models.HANDHELD);
    }
}
