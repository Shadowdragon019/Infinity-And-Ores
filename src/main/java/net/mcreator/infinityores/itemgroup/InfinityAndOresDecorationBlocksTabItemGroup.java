
package net.mcreator.infinityores.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.infinityores.block.GlitchedStationBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class InfinityAndOresDecorationBlocksTabItemGroup extends InfinityAndOresModElements.ModElement {
	public InfinityAndOresDecorationBlocksTabItemGroup(InfinityAndOresModElements instance) {
		super(instance, 197);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabinfinity_and_ores_decoration_blocks_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlitchedStationBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
