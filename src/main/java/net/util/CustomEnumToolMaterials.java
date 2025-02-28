package net.util;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Supplier;

public enum CustomEnumToolMaterials implements ToolMaterial {
    COPPER(CustomTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 200, 5.0F, 1F, 8, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    AMETHYST(CustomTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL, 150, 6F, 1F, 10, () -> Ingredient.ofItems(Items.AMETHYST_SHARD));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    CustomEnumToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed,
                            final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }



}
