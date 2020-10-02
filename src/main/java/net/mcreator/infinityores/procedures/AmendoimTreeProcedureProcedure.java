package net.mcreator.infinityores.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.trees.Tree;
import net.minecraft.block.Blocks;

import net.mcreator.infinityores.block.AmendoimFungusBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimTreeProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public AmendoimTreeProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 287);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AmendoimTreeProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AmendoimTreeProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AmendoimTreeProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AmendoimTreeProcedure!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double Tree = 0;
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.VOID_AIR.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
								.getBlock())))) {
			Tree = (double) ((new java.util.Random()).nextInt((int) 9 + 1));
			if (((Tree) == 0)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_tallest"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 5), (int) y, (int) (z - 3)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 1)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_taller"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 3)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 2)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_average"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 3)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_tiny"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 4)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_medium"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 5)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_small"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 6)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_mushroom_tiny"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 1), (int) y, (int) (z - 1)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 7)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_fungi_small"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 8)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("infinity_and_ores", "amendoim_fungi_medium"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else if (((Tree) == 9)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), AmendoimFungusBlock.block.getDefaultState(), 3);
			}
		}
	}
}
