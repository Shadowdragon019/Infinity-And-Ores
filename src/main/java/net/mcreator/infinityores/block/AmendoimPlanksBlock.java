
package net.mcreator.infinityores.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.infinityores.itemgroup.InfinityAndOresBuildingBlocksTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.List;
import java.util.Collections;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimPlanksBlock extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:amendoim_planks")
	public static final Block block = null;
	public AmendoimPlanksBlock(InfinityAndOresModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(InfinityAndOresBuildingBlocksTabItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.AXE));
			setRegistryName("amendoim_planks");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
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
