package net.mcreator.infinityores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.infinityores.block.MantleBlock;
import net.mcreator.infinityores.block.GlitchedSoilBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;
import net.mcreator.infinityores.InfinityAndOresMod;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class GlomperTeethAdditionalGenerationProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public GlomperTeethAdditionalGenerationProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 364);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency x for procedure GlomperTeethAdditionalGenerationProcedure!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency y for procedure GlomperTeethAdditionalGenerationProcedure!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency z for procedure GlomperTeethAdditionalGenerationProcedure!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency world for procedure GlomperTeethAdditionalGenerationProcedure!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == MantleBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == GlitchedSoilBlock.block.getDefaultState()
						.getBlock()))
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock()))) {
			return (true);
		}
		return (false);
	}
}
