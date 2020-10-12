
package net.mcreator.infinityores.block;

import net.minecraft.block.material.Material;

@InfinityAndOresModElements.ModElement.Tag
public class RedGlowCrystalBlockBlock extends InfinityAndOresModElements.ModElement {

	@ObjectHolder("infinity_and_ores:red_glow_crystal_block")
	public static final Block block = null;

	public RedGlowCrystalBlockBlock(InfinityAndOresModElements instance) {
		super(instance, 534);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(InfinityAndOresBuildingBlocksTabItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.REDSTONE_LIGHT).sound(SoundType.GLASS).hardnessAndResistance(0.3f, 0.3f).lightValue(15)
							.notSolid());

			setRegistryName("red_glow_crystal_block");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public boolean isEmissiveRendering(BlockState blockState) {
			return true;
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
