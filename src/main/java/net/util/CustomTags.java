package net.util;

import net.MoreTools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CustomTags {
    public static class Blocks {
        public static final TagKey<Block> MULTI_TOOL_MINEABLE = createTag("multi_tool_mineable");

        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_AMETHYST_TOOL = createTag("incorrect_for_amethyst_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreTools.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BIG_SHOVELS = createTag("big_shovels");
        public static final TagKey<Item> CLEAVERS = createTag("cleavers");
        public static final TagKey<Item> HAMMERS = createTag("hammers");
        public static final TagKey<Item> BIG_HOES = createTag("big_hoes");

        public static final TagKey<Item> BIG_TOOLS = createTag("big_tools");

        public static final TagKey<Item> OMNY_TOOLS = createTag("omny_tools");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreTools.MOD_ID, name));
        }
    }
}
