package net.datagen;

import net.MoreTools;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.item.CustomModItem;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void generateBigToolRecipe(RecipeExporter exporter, Item resultItem, Item tool, TagKey<Item> tagItem) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
                .pattern("#x#")
                .pattern(" / ")
                .pattern(" / ")
                .input('#', tagItem)
                .input('x', tool)
                .input('/', Items.STICK)
                .criterion("", RecipeProvider.conditionsFromItem(resultItem))
                .criterion("", RecipeProvider.conditionsFromTag(tagItem))
                .criterion("", RecipeProvider.conditionsFromItem(tool))
                .criterion("", RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void generateBigToolRecipe(RecipeExporter exporter, Item resultItem, Item tool, Item resource) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
                .pattern("#x#")
                .pattern(" / ")
                .pattern(" / ")
                .input('#', resource)
                .input('x', tool)
                .input('/', Items.STICK)
                .criterion("", RecipeProvider.conditionsFromItem(resultItem))
                .criterion("", RecipeProvider.conditionsFromItem(resource))
                .criterion("", RecipeProvider.conditionsFromItem(tool))
                .criterion("", RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void generateOmnyToolRecipe(RecipeExporter exporter, Item resultItem, Item tool1, Item tool2, Item tool3) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, resultItem)
                .pattern("123")
                .pattern(" / ")
                .pattern(" / ")
                .input('1', tool1)
                .input('2', tool2)
                .input('3', tool3)
                .input('/', Items.STICK)
                .criterion("", RecipeProvider.conditionsFromItem(resultItem))
                .criterion("", RecipeProvider.conditionsFromItem(tool1))
                .criterion("", RecipeProvider.conditionsFromItem(tool2))
                .criterion("", RecipeProvider.conditionsFromItem(tool3))
                .criterion("", RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
    public static void generateToolRecipes(RecipeExporter exporter, Item material, Item shovel, Item axe, Item pickaxe, Item hoe, Item sword) {
        createToolRecipe(exporter, shovel, material, "#", "/", "/");
        createToolRecipe(exporter, axe, material, "##", "#/", " /");
        createToolRecipe(exporter, pickaxe, material, "###", " / ", " / ");
        createToolRecipe(exporter, hoe, material, "##", " /", " /");
        createToolRecipe(exporter, sword, material, "#", "#", "/");
    }
    private static void createToolRecipe(RecipeExporter exporter, Item result, Item material, String row1, String row2, String row3) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern(row1)
                .pattern(row2)
                .pattern(row3)
                .input('#', material)
                .input('/', Items.STICK)
                .criterion("has_material", RecipeProvider.conditionsFromItem(material))
                .criterion("has_stick", RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }

    public static void generateSmithingTransformToolRecipe(RecipeExporter exporter, Item template, Item base_tool, Item materials, Item result_item, RecipeCategory recipeCategory) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template),
                        Ingredient.ofItems(base_tool),
                        Ingredient.ofItems(materials),
                        recipeCategory,
                        result_item)
                .criterion(hasItem(base_tool), conditionsFromItem(base_tool))
                .criterion(hasItem(materials), conditionsFromItem(materials))
                .criterion(hasItem(result_item), conditionsFromItem(result_item))
                .offerTo(exporter, result_item.getName().getString().replace("item."+ MoreTools.MOD_ID +".", "") + "_smithing");
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_BIG_SHOVEL, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_SHOVEL, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_BIG_SHOVEL_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_SHOVEL_LVL_2, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.NETHERITE_BIG_SHOVEL_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_SHOVEL_LVL_3, RecipeCategory.TOOLS);

        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_CLEAVER, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_CLEAVER, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_CLEAVER_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_CLEAVER_LVL_2, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.NETHERITE_CLEAVER_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_CLEAVER_LVL_3, RecipeCategory.TOOLS);

        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_HAMMER, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_HAMMER, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_HAMMER_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_HAMMER_LVL_2, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.NETHERITE_HAMMER_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_HAMMER_LVL_3, RecipeCategory.TOOLS);

        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_BIG_HOE, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_HOE, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_BIG_HOE_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_HOE_LVL_2, RecipeCategory.TOOLS);
        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.NETHERITE_BIG_HOE_LVL_2, Items.NETHERITE_BLOCK, CustomModItem.NETHERITE_BIG_HOE_LVL_3, RecipeCategory.TOOLS);

        generateSmithingTransformToolRecipe(exporter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, CustomModItem.DIAMOND_OMNI_TOOL, Items.NETHERITE_INGOT, CustomModItem.NETHERITE_OMNI_TOOL, RecipeCategory.TOOLS);

        generateOmnyToolRecipe(exporter, CustomModItem.STONE_OMNI_TOOL, Items.STONE_SHOVEL, Items.STONE_PICKAXE, Items.STONE_AXE);
        generateOmnyToolRecipe(exporter, CustomModItem.COPPER_OMNI_TOOL, CustomModItem.COPPER_SHOVEL, CustomModItem.COPPER_PICKAXE, CustomModItem.COPPER_AXE);
        generateOmnyToolRecipe(exporter, CustomModItem.AMETHYST_OMNI_TOOL, CustomModItem.AMETHYST_SHOVEL, CustomModItem.AMETHYST_PICKAXE, CustomModItem.AMETHYST_AXE);
        generateOmnyToolRecipe(exporter, CustomModItem.IRON_OMNI_TOOL, Items.IRON_SHOVEL, Items.IRON_PICKAXE, Items.IRON_AXE);
        generateOmnyToolRecipe(exporter, CustomModItem.GOLDEN_OMNI_TOOL, Items.GOLDEN_SHOVEL, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE);
        generateOmnyToolRecipe(exporter, CustomModItem.DIAMOND_OMNI_TOOL, Items.DIAMOND_SHOVEL, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE);

        generateBigToolRecipe(exporter, CustomModItem.STONE_BIG_SHOVEL, Items.STONE_SHOVEL, ItemTags.STONE_CRAFTING_MATERIALS);
        generateBigToolRecipe(exporter, CustomModItem.COPPER_BIG_SHOVEL, CustomModItem.COPPER_SHOVEL, Items.COPPER_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.AMETHYST_BIG_SHOVEL, CustomModItem.AMETHYST_SHOVEL, Items.AMETHYST_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_BIG_SHOVEL, Items.IRON_SHOVEL, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_BIG_SHOVEL_LVL_2, CustomModItem.IRON_BIG_SHOVEL, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.GOLDEN_BIG_SHOVEL, Items.GOLDEN_SHOVEL, Items.GOLD_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_BIG_SHOVEL, Items.DIAMOND_SHOVEL, Items.DIAMOND_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_BIG_SHOVEL_LVL_2, CustomModItem.DIAMOND_BIG_SHOVEL, Items.DIAMOND_BLOCK);

        generateBigToolRecipe(exporter, CustomModItem.STONE_CLEAVER, Items.STONE_AXE, ItemTags.STONE_CRAFTING_MATERIALS);
        generateBigToolRecipe(exporter, CustomModItem.COPPER_CLEAVER, CustomModItem.COPPER_AXE, Items.COPPER_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.AMETHYST_CLEAVER, CustomModItem.AMETHYST_AXE, Items.AMETHYST_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_CLEAVER, Items.IRON_AXE, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_CLEAVER_LVL_2, CustomModItem.IRON_CLEAVER, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.GOLDEN_CLEAVER, Items.GOLDEN_AXE,Items.GOLD_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_CLEAVER, Items.DIAMOND_AXE,Items.DIAMOND_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_CLEAVER_LVL_2, CustomModItem.DIAMOND_CLEAVER,Items.DIAMOND_BLOCK);

        generateBigToolRecipe(exporter, CustomModItem.STONE_HAMMER, Items.STONE_PICKAXE, ItemTags.STONE_CRAFTING_MATERIALS);
        generateBigToolRecipe(exporter, CustomModItem.COPPER_HAMMER, CustomModItem.COPPER_PICKAXE, Items.COPPER_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.AMETHYST_HAMMER, CustomModItem.AMETHYST_PICKAXE, Items.AMETHYST_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_HAMMER, Items.IRON_PICKAXE, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_HAMMER_LVL_2, CustomModItem.IRON_HAMMER, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.GOLDEN_HAMMER, Items.GOLDEN_PICKAXE, Items.GOLD_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_HAMMER, Items.DIAMOND_PICKAXE, Items.DIAMOND_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_HAMMER_LVL_2, CustomModItem.DIAMOND_HAMMER, Items.DIAMOND_BLOCK);

        generateBigToolRecipe(exporter, CustomModItem.STONE_BIG_HOE, Items.STONE_HOE, ItemTags.STONE_CRAFTING_MATERIALS);
        generateBigToolRecipe(exporter, CustomModItem.COPPER_BIG_HOE, CustomModItem.COPPER_HOE, Items.COPPER_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.AMETHYST_BIG_HOE, CustomModItem.AMETHYST_HOE, Items.AMETHYST_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_BIG_HOE, Items.IRON_HOE, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.IRON_BIG_HOE_LVL_2, CustomModItem.IRON_BIG_HOE, Items.IRON_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.GOLDEN_BIG_HOE, Items.GOLDEN_HOE, Items.GOLD_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_BIG_HOE, Items.DIAMOND_HOE, Items.DIAMOND_BLOCK);
        generateBigToolRecipe(exporter, CustomModItem.DIAMOND_BIG_HOE_LVL_2, CustomModItem.DIAMOND_BIG_HOE, Items.DIAMOND_BLOCK);

        generateToolRecipes(exporter,
                Items.COPPER_INGOT,
                CustomModItem.COPPER_SHOVEL,
                CustomModItem.COPPER_AXE,
                CustomModItem.COPPER_PICKAXE,
                CustomModItem.COPPER_HOE,
                CustomModItem.COPPER_SWORD);
        generateToolRecipes(exporter,
                Items.AMETHYST_SHARD,
                CustomModItem.AMETHYST_SHOVEL,
                CustomModItem.AMETHYST_AXE,
                CustomModItem.AMETHYST_PICKAXE,
                CustomModItem.AMETHYST_HOE,
                CustomModItem.AMETHYST_SWORD);

    }
}
