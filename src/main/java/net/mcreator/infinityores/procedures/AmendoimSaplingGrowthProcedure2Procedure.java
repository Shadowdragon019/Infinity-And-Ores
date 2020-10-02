package net.mcreator.infinityores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;
import java.util.HashMap;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimSaplingGrowthProcedure2Procedure extends InfinityAndOresModElements.ModElement {
	public AmendoimSaplingGrowthProcedure2Procedure(InfinityAndOresModElements instance) {
		super(instance, 377);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AmendoimSaplingGrowthProcedure2!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AmendoimSaplingGrowthProcedure2!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AmendoimSaplingGrowthProcedure2!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AmendoimSaplingGrowthProcedure2!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.875)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				AmendoimTree2ProcedureProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
