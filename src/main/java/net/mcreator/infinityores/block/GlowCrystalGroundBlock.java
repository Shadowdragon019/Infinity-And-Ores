
package net.mcreator.infinityores.block;

import net.minecraft.block.material.Material;

@InfinityAndOresModElements.ModElement.Tag
public class GlowCrystalGroundBlock extends InfinityAndOresModElements.ModElement {

	@ObjectHolder("infinity_and_ores:glow_crystal_ground")
	public static final Block block = null;

	public GlowCrystalGroundBlock(InfinityAndOresModElements instance) {
		super(instance, 531);

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
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public static final DirectionProperty FACING = DirectionalBlock.FACING;

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(1f, 1f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE).notSolid());

			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

			setRegistryName("glow_crystal_ground");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.create(0.8125D, 0.188D, 0.75D, 0.1875D, 0.812D, 0D);
				case NORTH :
					return VoxelShapes.create(0.1875D, 0.188D, 0.25D, 0.8125D, 0.812D, 1D);
				case WEST :
					return VoxelShapes.create(0.25D, 0.188D, 0.8125D, 1D, 0.812D, 0.1875D);
				case EAST :
					return VoxelShapes.create(0.75D, 0.188D, 0.1875D, 0D, 0.812D, 0.8125D);
				case UP :
					return VoxelShapes.create(0.1875D, 0.75D, 0.188D, 0.8125D, 0D, 0.812D);
				case DOWN :
					return VoxelShapes.create(0.1875D, 0.25D, 0.812D, 0.8125D, 1D, 0.188D);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			return this.getDefaultState().with(FACING, context.getFace());
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
