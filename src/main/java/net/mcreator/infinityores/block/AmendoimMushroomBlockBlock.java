
package net.mcreator.infinityores.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.infinityores.itemgroup.InfinityAndOresDecorationBlocksTabItemGroup;
import net.mcreator.infinityores.item.AmendoimMushroomItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.List;
import java.util.Collections;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimMushroomBlockBlock extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:amendoim_mushroom_block")
	public static final Block block = null;
	public AmendoimMushroomBlockBlock(InfinityAndOresModElements instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(InfinityAndOresDecorationBlocksTabItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.WET_GRASS).hardnessAndResistance(0.2f, 0.5f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.AXE));
			setRegistryName("amendoim_mushroom_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(AmendoimMushroomItem.block, (int) (2)));
		}
	}
}
