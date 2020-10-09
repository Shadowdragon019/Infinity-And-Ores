
package net.mcreator.infinityores.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.infinityores.block.GlitchedOreBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class InfinityAndOresBuildingBlocksTabItemGroup extends InfinityAndOresModElements.ModElement {
	public InfinityAndOresBuildingBlocksTabItemGroup(InfinityAndOresModElements instance) {
		super(instance, 223);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabinfinity_and_ores_building_blocks_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlitchedOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
