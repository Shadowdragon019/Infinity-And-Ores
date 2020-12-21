
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.infinityores.itemgroup.InfinityAndOresToolsAndArmorsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class EndesuliteSwordItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:endesulite_sword")
	public static final Item block = null;
	public EndesuliteSwordItem(InfinityAndOresModElements instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3774;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 55;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndesuliteCrystalItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
		}.setRegistryName("endesulite_sword"));
	}
}
