package net.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.util.CustomTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CustomTags.Blocks.MULTI_TOOL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);

        getOrCreateTagBuilder(CustomTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(CustomTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
