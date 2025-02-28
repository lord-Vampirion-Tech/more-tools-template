package net.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.item.CustomModItem;
import net.util.CustomTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CustomTags.Items.BIG_TOOLS)
                .forceAddTag(CustomTags.Items.HAMMERS)
                .forceAddTag(CustomTags.Items.CLEAVERS)
                .forceAddTag(CustomTags.Items.BIG_SHOVELS)
                .forceAddTag(CustomTags.Items.BIG_HOES);

        getOrCreateTagBuilder(CustomTags.Items.OMNY_TOOLS)
                .add(CustomModItem.STONE_OMNI_TOOL)
                .add(CustomModItem.COPPER_OMNI_TOOL)
                .add(CustomModItem.AMETHYST_OMNI_TOOL)
                .add(CustomModItem.IRON_OMNI_TOOL)
                .add(CustomModItem.GOLDEN_OMNI_TOOL)
                .add(CustomModItem.DIAMOND_OMNI_TOOL)
                .add(CustomModItem.NETHERITE_OMNI_TOOL);

        getOrCreateTagBuilder(CustomTags.Items.BIG_SHOVELS)
                .add(CustomModItem.STONE_BIG_SHOVEL)
                .add(CustomModItem.COPPER_BIG_SHOVEL)
                .add(CustomModItem.AMETHYST_SHOVEL)
                .add(CustomModItem.IRON_BIG_SHOVEL)
                .add(CustomModItem.IRON_BIG_SHOVEL_LVL_2)
                .add(CustomModItem.GOLDEN_BIG_SHOVEL)
                .add(CustomModItem.DIAMOND_BIG_SHOVEL)
                .add(CustomModItem.DIAMOND_BIG_SHOVEL_LVL_2)
                .add(CustomModItem.NETHERITE_BIG_SHOVEL)
                .add(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_2)
                .add(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_3);

        getOrCreateTagBuilder(CustomTags.Items.CLEAVERS)
                .add(CustomModItem.STONE_CLEAVER)
                .add(CustomModItem.COPPER_CLEAVER)
                .add(CustomModItem.AMETHYST_CLEAVER)
                .add(CustomModItem.IRON_CLEAVER)
                .add(CustomModItem.IRON_CLEAVER_LVL_2)
                .add(CustomModItem.GOLDEN_CLEAVER)
                .add(CustomModItem.DIAMOND_CLEAVER)
                .add(CustomModItem.DIAMOND_CLEAVER_LVL_2)
                .add(CustomModItem.NETHERITE_CLEAVER)
                .add(CustomModItem.NETHERITE_CLEAVER_LVL_2)
                .add(CustomModItem.NETHERITE_CLEAVER_LVL_3);

        getOrCreateTagBuilder(CustomTags.Items.HAMMERS)
                .add(CustomModItem.STONE_HAMMER)
                .add(CustomModItem.COPPER_HAMMER)
                .add(CustomModItem.AMETHYST_HAMMER)
                .add(CustomModItem.IRON_HAMMER)
                .add(CustomModItem.IRON_HAMMER_LVL_2)
                .add(CustomModItem.GOLDEN_HAMMER)
                .add(CustomModItem.DIAMOND_HAMMER)
                .add(CustomModItem.DIAMOND_HAMMER_LVL_2)
                .add(CustomModItem.NETHERITE_HAMMER)
                .add(CustomModItem.NETHERITE_HAMMER_LVL_2)
                .add(CustomModItem.NETHERITE_HAMMER_LVL_3);

        getOrCreateTagBuilder(CustomTags.Items.BIG_HOES)
                .add(CustomModItem.STONE_BIG_HOE)
                .add(CustomModItem.COPPER_BIG_HOE)
                .add(CustomModItem.AMETHYST_BIG_HOE)
                .add(CustomModItem.IRON_BIG_HOE)
                .add(CustomModItem.IRON_BIG_HOE_LVL_2)
                .add(CustomModItem.GOLDEN_BIG_HOE)
                .add(CustomModItem.DIAMOND_BIG_HOE)
                .add(CustomModItem.DIAMOND_BIG_HOE_LVL_2)
                .add(CustomModItem.NETHERITE_BIG_HOE)
                .add(CustomModItem.NETHERITE_BIG_HOE_LVL_2)
                .add(CustomModItem.NETHERITE_BIG_HOE_LVL_3);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .forceAddTag(CustomTags.Items.OMNY_TOOLS)
                .forceAddTag(CustomTags.Items.BIG_TOOLS);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .forceAddTag(CustomTags.Items.OMNY_TOOLS);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .forceAddTag(CustomTags.Items.OMNY_TOOLS)
                .forceAddTag(CustomTags.Items.BIG_TOOLS);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(CustomModItem.COPPER_SHOVEL)
                .add(CustomModItem.AMETHYST_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(CustomModItem.COPPER_AXE)
                .add(CustomModItem.AMETHYST_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(CustomModItem.COPPER_PICKAXE)
                .add(CustomModItem.AMETHYST_PICKAXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(CustomModItem.COPPER_HOE)
                .add(CustomModItem.AMETHYST_HOE);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(CustomModItem.COPPER_SWORD)
                .add(CustomModItem.AMETHYST_SWORD);
    }
}
