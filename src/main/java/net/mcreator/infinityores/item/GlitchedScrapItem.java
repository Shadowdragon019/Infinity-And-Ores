
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.infinityores.itemgroup.InfinityAndOresItemsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class GlitchedScrapItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:glitched_scrap")
	public static final Item block = null;
	public GlitchedScrapItem(InfinityAndOresModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("glitched_scrap");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
