
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class RawCrawlantMeatItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:raw_crawlant_meat")
	public static final Item block = null;
	public RawCrawlantMeatItem(InfinityAndOresModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.6f).meat().build()));
			setRegistryName("raw_crawlant_meat");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
