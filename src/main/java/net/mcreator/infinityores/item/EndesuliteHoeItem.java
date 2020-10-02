
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.infinityores.itemgroup.InfinityAndOresToolsAndArmorsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class EndesuliteHoeItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:endesulite_hoe")
	public static final Item block = null;
	public EndesuliteHoeItem(InfinityAndOresModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 3774;
			}

			public float getEfficiency() {
				return 20f;
			}

			public float getAttackDamage() {
				return -1f;
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
		}, 0f, new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
		}.setRegistryName("endesulite_hoe"));
	}
}
