
package net.mcreator.infinityores.item;

@InfinityAndOresModElements.ModElement.Tag
public class ChargedSoulLinkerItem extends InfinityAndOresModElements.ModElement {

	@ObjectHolder("infinity_and_ores:charged_soul_linker")
	public static final Item block = null;

	public ChargedSoulLinkerItem(InfinityAndOresModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxDamage(4));
			setRegistryName("charged_soul_linker");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"This food doesn't give its uncharged version as of now. This will change once Infinity & Ores will be updated to MCreator 2020.5."));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				ChargedSoulLinkerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

	}

}
