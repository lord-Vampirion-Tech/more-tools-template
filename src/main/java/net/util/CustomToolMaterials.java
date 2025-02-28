package net.util;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;


public class CustomToolMaterials implements ToolMaterial {
    private final ToolMaterial baseMaterial;
    private final float customDurability;
    private final float customMiningSpeed;
    private final float customAttackDamage;

    public CustomToolMaterials(ToolMaterial baseMaterial, float customDurability, float customMiningSpeed, float customAttackDamage) {
        this.baseMaterial = baseMaterial;
        this.customDurability = customDurability;
        this.customMiningSpeed = customMiningSpeed;
        this.customAttackDamage = customAttackDamage;
    }

    public static ToolMaterial CUSTOM(ToolMaterial toolMaterials, float durability, float miningSpeed, float attackDamage) {
        return new CustomToolMaterials(toolMaterials, toolMaterials.getDurability() * durability, toolMaterials.getMiningSpeedMultiplier() + miningSpeed, attackDamage);
    }

    public static ToolMaterial CUSTOM(ToolMaterial toolMaterials, float durability) {
        return CUSTOM(toolMaterials, durability, 0, toolMaterials.getAttackDamage());
    }


    @Override
    public int getDurability() {return (int) this.customDurability;}

    @Override
    public float getMiningSpeedMultiplier() {return customMiningSpeed;}

    @Override
    public float getAttackDamage() {return customAttackDamage;}

    @Override
    public TagKey<Block> getInverseTag() {return this.baseMaterial.getInverseTag();}

    @Override
    public int getEnchantability() {return this.baseMaterial.getEnchantability();}

    @Override
    public Ingredient getRepairIngredient() {return this.baseMaterial.getRepairIngredient();}

}
