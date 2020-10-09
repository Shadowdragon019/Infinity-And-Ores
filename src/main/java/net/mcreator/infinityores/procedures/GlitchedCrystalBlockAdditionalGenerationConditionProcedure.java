package net.mcreator.infinityores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.infinityores.block.MantleBlock;
import net.mcreator.infinityores.block.MantleAmendoimNyliumBlock;
import net.mcreator.infinityores.block.GlitchedSoilBlock;
import net.mcreator.infinityores.block.EnderAmendoimNyliumBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class GlitchedCrystalBlockAdditionalGenerationConditionProcedure extends InfinityAndOresModElements.ModElement {
	public GlitchedCrystalBlockAdditionalGenerationConditionProcedure(InfinityAndOresModElements instance) {
		super(instance, 160);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GlitchedCrystalBlockAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GlitchedCrystalBlockAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GlitchedCrystalBlockAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GlitchedCrystalBlockAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRANITE.getDefaultState().getBlock()))
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIORITE.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT.getDefaultState()
										.getBlock())
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.NETHERRACK
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
														.getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock())
														|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
																.getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())
																|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
																		.getBlock() == MantleAmendoimNyliumBlock.block.getDefaultState().getBlock())
																		|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
																				.getBlock() == EnderAmendoimNyliumBlock.block.getDefaultState()
																						.getBlock())
																				|| (((world
																						.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
																								.getBlock() == GlitchedSoilBlock.block
																										.getDefaultState().getBlock())
																						|| (((world.getBlockState(
																								new BlockPos((int) x, (int) (y - 1), (int) z)))
																										.getBlock() == MantleBlock.block
																												.getDefaultState().getBlock())
																								|| ((world.getBlockState(new BlockPos((int) x,
																										(int) (y - 1), (int) z)))
																												.getBlock() == Blocks.END_STONE
																														.getDefaultState()
																														.getBlock()))))))))))))
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock()))) {
			return (true);
		}
		return (false);
	}
}
