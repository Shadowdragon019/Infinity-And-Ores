
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.infinityores.itemgroup.InfinityAndOresToolsAndArmorsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class OpristoniumPickaxeItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:opristonium_pickaxe")
	public static final Item block = null;
	public OpristoniumPickaxeItem(InfinityAndOresModElements instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2698;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 33;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(OpristoniumGemItem.block, (int) (1)),
						new ItemStack(OpristoniumIngotItem.block, (int) (1)));
			}
		}, 1, -2.8f, new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
		}.setRegistryName("opristonium_pickaxe"));
	}
}
