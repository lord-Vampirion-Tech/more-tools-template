package net.item;

import net.MoreTools;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomModItemGroups {
    public static final ItemGroup MORE_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreTools.MOD_ID, "more_tools_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(CustomModItem.NETHERITE_HAMMER))
                    .displayName(Text.translatable("more_tools.more_tools_group"))
                    .entries(((displayContext, entries) -> {

                        entries.add(CustomModItem.STONE_BIG_SHOVEL);
                        entries.add(CustomModItem.COPPER_BIG_SHOVEL);
                        entries.add(CustomModItem.AMETHYST_BIG_SHOVEL);
                        entries.add(CustomModItem.IRON_BIG_SHOVEL);
                        entries.add(CustomModItem.IRON_BIG_SHOVEL_LVL_2);
                        entries.add(CustomModItem.GOLDEN_BIG_SHOVEL);
                        entries.add(CustomModItem.DIAMOND_BIG_SHOVEL);
                        entries.add(CustomModItem.DIAMOND_BIG_SHOVEL_LVL_2);
                        entries.add(CustomModItem.NETHERITE_BIG_SHOVEL);
                        entries.add(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_2);
                        entries.add(CustomModItem.NETHERITE_BIG_SHOVEL_LVL_3);

                        entries.add(CustomModItem.STONE_CLEAVER);
                        entries.add(CustomModItem.COPPER_CLEAVER);
                        entries.add(CustomModItem.AMETHYST_CLEAVER);
                        entries.add(CustomModItem.IRON_CLEAVER);
                        entries.add(CustomModItem.IRON_CLEAVER_LVL_2);
                        entries.add(CustomModItem.GOLDEN_CLEAVER);
                        entries.add(CustomModItem.DIAMOND_CLEAVER);
                        entries.add(CustomModItem.DIAMOND_CLEAVER_LVL_2);
                        entries.add(CustomModItem.NETHERITE_CLEAVER);
                        entries.add(CustomModItem.NETHERITE_CLEAVER_LVL_2);
                        entries.add(CustomModItem.NETHERITE_CLEAVER_LVL_3);

                        entries.add(CustomModItem.STONE_HAMMER);
                        entries.add(CustomModItem.COPPER_HAMMER);
                        entries.add(CustomModItem.AMETHYST_HAMMER);
                        entries.add(CustomModItem.IRON_HAMMER);
                        entries.add(CustomModItem.IRON_HAMMER_LVL_2);
                        entries.add(CustomModItem.GOLDEN_HAMMER);
                        entries.add(CustomModItem.DIAMOND_HAMMER);
                        entries.add(CustomModItem.DIAMOND_HAMMER_LVL_2);
                        entries.add(CustomModItem.NETHERITE_HAMMER);
                        entries.add(CustomModItem.NETHERITE_HAMMER_LVL_2);
                        entries.add(CustomModItem.NETHERITE_HAMMER_LVL_3);

                        entries.add(CustomModItem.STONE_BIG_HOE);
                        entries.add(CustomModItem.COPPER_BIG_HOE);
                        entries.add(CustomModItem.AMETHYST_BIG_HOE);
                        entries.add(CustomModItem.IRON_BIG_HOE);
                        entries.add(CustomModItem.IRON_BIG_HOE_LVL_2);
                        entries.add(CustomModItem.GOLDEN_BIG_HOE);
                        entries.add(CustomModItem.DIAMOND_BIG_HOE);
                        entries.add(CustomModItem.DIAMOND_BIG_HOE_LVL_2);
                        entries.add(CustomModItem.NETHERITE_BIG_HOE);
                        entries.add(CustomModItem.NETHERITE_BIG_HOE_LVL_2);
                        entries.add(CustomModItem.NETHERITE_BIG_HOE_LVL_3);
                    })).build());

    public static void initialize() {MoreTools.LOGGER.info("Registering {} item groups", MoreTools.MOD_ID);}
}
