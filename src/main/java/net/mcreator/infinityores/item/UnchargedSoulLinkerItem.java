
package net.mcreator.infinityores.item;

@InfinityAndOresModElements.ModElement.Tag
public class UnchargedSoulLinkerItem extends InfinityAndOresModElements.ModElement {

	@ObjectHolder("infinity_and_ores:uncharged_soul_linker")
	public static final Item block = null;

	public UnchargedSoulLinkerItem(InfinityAndOresModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxStackSize(1));
			setRegistryName("uncharged_soul_linker");
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
