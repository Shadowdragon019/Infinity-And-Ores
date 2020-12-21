package net.mcreator.infinityores.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;

import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class GlitchedResidueRightClickedOnBlockProcedure extends InfinityAndOresModElements.ModElement {
	public GlitchedResidueRightClickedOnBlockProcedure(InfinityAndOresModElements instance) {
		super(instance, 538);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GlitchedResidueRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GlitchedResidueRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GlitchedResidueRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GlitchedResidueRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z)) || BoneMealItem
				.growSeagrass(new ItemStack(Items.BONE_MEAL), world.getWorld(), new BlockPos((int) x, (int) y, (int) z), (Direction) null)) {
			if (!world.getWorld().isRemote)
				world.getWorld().playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
		}
	}
}
