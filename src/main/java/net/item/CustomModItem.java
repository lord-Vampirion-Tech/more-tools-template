package net.item;

import net.MoreTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.item.Custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.util.CustomEnumToolMaterials;
import net.util.CustomModComponents;
import net.util.CustomTags;

import static net.util.CustomToolMaterials.CUSTOM;

public class CustomModItem {
    //каменные инструменты
    public static final Item STONE_BIG_SHOVEL = registerItem("stone_big_shovel", new Custom_Shovel(CUSTOM(ToolMaterials.STONE, 3.5f), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item STONE_CLEAVER = registerItem("stone_cleaver", new Custom_Cleaver(CUSTOM(ToolMaterials.STONE, 3.5f), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item STONE_HAMMER = registerItem("stone_hammer", new Custom_Hummer(CUSTOM(ToolMaterials.STONE, 3.5f), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item STONE_BIG_HOE = registerItem("stone_big_hoe", new Custom_Hoe(CUSTOM(ToolMaterials.STONE, 3.5f), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item STONE_OMNI_TOOL = registerItem("stone_omni_tool", new Omni_tool(CUSTOM(ToolMaterials.STONE, 3.5f), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.STONE_HOE});

    //медные инструменты
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(CustomEnumToolMaterials.COPPER, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.COPPER, 1.5f, -3.0f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(CustomEnumToolMaterials.COPPER, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.COPPER, 1.5f, -2.8f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(CustomEnumToolMaterials.COPPER, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.COPPER, 7f, -3.2f))), new RegistryKey[]{ItemGroups.TOOLS,ItemGroups.COMBAT}, new Item[]{Items.IRON_SHOVEL,Items.IRON_AXE});
    public static final Item COPPER_HOE = registerItem("copper_hoe", new HoeItem(CustomEnumToolMaterials.COPPER, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.COPPER, -1f, -1.0f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item COPPER_SWORD = registerItem("copper_sword", new SwordItem(CustomEnumToolMaterials.COPPER, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.COPPER, 3, -2.4f))), new RegistryKey[]{ItemGroups.COMBAT}, new Item[]{Items.IRON_SWORD});

    public static final Item COPPER_BIG_SHOVEL = registerItem("copper_big_shovel", new Custom_Shovel(CUSTOM(CustomEnumToolMaterials.COPPER, 3.5f), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item COPPER_CLEAVER = registerItem("copper_cleaver", new Custom_Cleaver(CUSTOM(CustomEnumToolMaterials.COPPER, 3.5f), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item COPPER_HAMMER = registerItem("copper_hammer", new Custom_Hummer(CUSTOM(CustomEnumToolMaterials.COPPER, 3.5f), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item COPPER_BIG_HOE = registerItem("copper_big_hoe", new Custom_Hoe(CUSTOM(CustomEnumToolMaterials.COPPER, 3.5f), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item COPPER_OMNI_TOOL = registerItem("copper_omni_tool", new Omni_tool(CUSTOM(CustomEnumToolMaterials.COPPER, 3.5f), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{CustomModItem.COPPER_HOE});

    //Аметистовые инструменты
    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel", new ShovelItem(CustomEnumToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.AMETHYST, 1.5f, -2.6f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe", new PickaxeItem(CustomEnumToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.AMETHYST, 1.5f, -2.2f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item AMETHYST_AXE = registerItem("amethyst_axe", new AxeItem(CustomEnumToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.AMETHYST, 7f, -2.6f))), new RegistryKey[]{ItemGroups.TOOLS, ItemGroups.COMBAT}, new Item[]{Items.IRON_SHOVEL,Items.IRON_AXE});
    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe", new HoeItem(CustomEnumToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.AMETHYST, -1f, -.5f))), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_SHOVEL});
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword", new SwordItem(CustomEnumToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(MiningToolItem.createAttributeModifiers(CustomEnumToolMaterials.AMETHYST, 3, -2f))), new RegistryKey[]{ItemGroups.COMBAT}, new Item[]{Items.IRON_SWORD});

    public static final Item AMETHYST_BIG_SHOVEL = registerItem("amethyst_big_shovel", new Custom_Shovel(CUSTOM(CustomEnumToolMaterials.AMETHYST, 3), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item AMETHYST_CLEAVER = registerItem("amethyst_cleaver", new Custom_Cleaver(CUSTOM(CustomEnumToolMaterials.AMETHYST, 3), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item AMETHYST_HAMMER = registerItem("amethyst_hammer", new Custom_Hummer(CUSTOM(CustomEnumToolMaterials.AMETHYST, 3), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item AMETHYST_BIG_HOE = registerItem("amethyst_big_hoe", new Custom_Hoe(CUSTOM(CustomEnumToolMaterials.AMETHYST, 3), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item AMETHYST_OMNI_TOOL = registerItem("amethyst_omni_tool", new Omni_tool(CUSTOM(CustomEnumToolMaterials.AMETHYST, 2), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{CustomModItem.AMETHYST_HOE});

    //железные инструменты
    public static final Item IRON_BIG_SHOVEL = registerItem("iron_big_shovel", new Custom_Shovel(CUSTOM(ToolMaterials.IRON, 4), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_CLEAVER = registerItem("iron_cleaver", new Custom_Cleaver(CUSTOM(ToolMaterials.IRON, 4), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer", new Custom_Hummer(CUSTOM(ToolMaterials.IRON, 4), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_BIG_HOE = registerItem("iron_big_hoe", new Custom_Hoe(CUSTOM(ToolMaterials.IRON, 4), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_BIG_SHOVEL_LVL_2 = registerItem("iron_big_shovel_lvl_2", new Custom_Shovel(CUSTOM(ToolMaterials.IRON, 4), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_CLEAVER_LVL_2 = registerItem("iron_cleaver_lvl_2", new Custom_Cleaver(CUSTOM(ToolMaterials.IRON, 4), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item IRON_HAMMER_LVL_2 = registerItem("iron_hammer_lvl_2", new Custom_Hummer(CUSTOM(ToolMaterials.IRON, 4), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_BIG_HOE_LVL_2 = registerItem("iron_big_hoe_lvl_2", new Custom_Hoe(CUSTOM(ToolMaterials.IRON, 4), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item IRON_OMNI_TOOL = registerItem("iron_omni_tool", new Omni_tool(CUSTOM(ToolMaterials.IRON, 2), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.IRON_HOE});

    //золотые инструменты
    public static final Item GOLDEN_BIG_SHOVEL = registerItem("golden_big_shovel", new Custom_Shovel(CUSTOM(ToolMaterials.GOLD, 3), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item GOLDEN_CLEAVER = registerItem("golden_cleaver", new Custom_Cleaver(CUSTOM(ToolMaterials.GOLD, 3), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer", new Custom_Hummer(CUSTOM(ToolMaterials.GOLD, 3), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item GOLDEN_BIG_HOE = registerItem("golden_big_hoe", new Custom_Hoe(CUSTOM(ToolMaterials.GOLD, 3), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item GOLDEN_OMNI_TOOL = registerItem("golden_omni_tool", new Omni_tool(CUSTOM(ToolMaterials.GOLD, 2f), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.GOLDEN_HOE});

    //алмазные инструменты
    public static final Item DIAMOND_BIG_SHOVEL = registerItem("diamond_big_shovel", new Custom_Shovel(CUSTOM(ToolMaterials.DIAMOND, 4), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_CLEAVER = registerItem("diamond_cleaver", new Custom_Cleaver(CUSTOM(ToolMaterials.DIAMOND, 4), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer", new Custom_Hummer(CUSTOM(ToolMaterials.DIAMOND, 4), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_BIG_HOE = registerItem("diamond_big_hoe", new Custom_Hoe(CUSTOM(ToolMaterials.DIAMOND, 4), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_BIG_SHOVEL_LVL_2 = registerItem("diamond_big_shovel_lvl_2", new Custom_Shovel(CUSTOM(ToolMaterials.DIAMOND, 6), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_CLEAVER_LVL_2 = registerItem("diamond_cleaver_lvl_2", new Custom_Cleaver(CUSTOM(ToolMaterials.DIAMOND, 6), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item DIAMOND_HAMMER_LVL_2 = registerItem("diamond_hammer_lvl_2", new Custom_Hummer(CUSTOM(ToolMaterials.DIAMOND, 6), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_BIG_HOE_LVL_2 = registerItem("diamond_big_hoe_lvl_2", new Custom_Hoe(CUSTOM(ToolMaterials.DIAMOND, 6), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item DIAMOND_OMNI_TOOL = registerItem("diamond_omni_tool", new Omni_tool(CUSTOM(ToolMaterials.DIAMOND, 2f), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.DIAMOND_HOE});
    //незеритовые инструменты
    public static final Item NETHERITE_BIG_SHOVEL = registerItem("netherite_big_shovel", new Custom_Shovel(CUSTOM(ToolMaterials.NETHERITE, 4), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_CLEAVER = registerItem("netherite_cleaver", new Custom_Cleaver(CUSTOM(ToolMaterials.NETHERITE, 4), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer", new Custom_Hummer(CUSTOM(ToolMaterials.NETHERITE, 4), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_BIG_HOE = registerItem("netherite_big_hoe", new Custom_Hoe(CUSTOM(ToolMaterials.NETHERITE, 4), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 1)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_BIG_SHOVEL_LVL_2 = registerItem("netherite_big_shovel_lvl_2", new Custom_Shovel(CUSTOM(ToolMaterials.NETHERITE, 6), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_CLEAVER_LVL_2 = registerItem("netherite_cleaver_lvl_2", new Custom_Cleaver(CUSTOM(ToolMaterials.NETHERITE, 6), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item NETHERITE_HAMMER_LVL_2 = registerItem("netherite_hammer_lvl_2", new Custom_Hummer(CUSTOM(ToolMaterials.NETHERITE, 6), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_BIG_HOE_LVL_2 = registerItem("netherite_big_hoe_lvl_2", new Custom_Hoe(CUSTOM(ToolMaterials.NETHERITE, 6), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 2)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_BIG_SHOVEL_LVL_3 = registerItem("netherite_big_shovel_lvl_3", new Custom_Shovel(CUSTOM(ToolMaterials.NETHERITE, 8), BlockTags.SHOVEL_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 3)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_CLEAVER_LVL_3 = registerItem("netherite_cleaver_lvl_3", new Custom_Cleaver(CUSTOM(ToolMaterials.NETHERITE, 8), BlockTags.AXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 3)
            .component(CustomModComponents.DEEP, 2)));
    public static final Item NETHERITE_HAMMER_LVL_3 = registerItem("netherite_hammer_lvl_3", new Custom_Hummer(CUSTOM(ToolMaterials.NETHERITE, 8), BlockTags.PICKAXE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 3)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_BIG_HOE_LVL_3 = registerItem("netherite_big_hoe_lvl_3", new Custom_Hoe(CUSTOM(ToolMaterials.NETHERITE, 8), BlockTags.HOE_MINEABLE, new Item.Settings()
            .component(CustomModComponents.SIZE, 3)
            .component(CustomModComponents.DEEP, 0)));
    public static final Item NETHERITE_OMNI_TOOL = registerItem("netherite_omni_tool", new Omni_tool(CUSTOM(ToolMaterials.NETHERITE, 3f), CustomTags.Blocks.MULTI_TOOL_MINEABLE, new Item.Settings()), new RegistryKey[]{ItemGroups.TOOLS}, new Item[]{Items.NETHERITE_HOE});


    static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreTools.MOD_ID, name), item);
    }
    static Item registerItem(String name, Item item, RegistryKey<ItemGroup>[] groups, Item[] afterItems) {
        Item registeredItem = registerItem(name, item);

        if (afterItems == null) {afterItems = new Item[groups.length];}

        for (int i = 0; i < groups.length; i++) {
            Item afterItem = afterItems[i];
            ItemGroupEvents.modifyEntriesEvent(groups[i]).register(entries -> {
                if (afterItem != null) entries.addBefore(afterItem, registeredItem);
                else                   entries.add(registeredItem);
            });
        }

        return registeredItem;
    }

    public static void initialize() {
        MoreTools.LOGGER.info("Registering {} items", MoreTools.MOD_ID);
    }
}
