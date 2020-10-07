
package net.mcreator.infinityores.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.infinityores.item.GlitchedSwordItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class InfinityAndOresToolsAndArmorsTabItemGroup extends InfinityAndOresModElements.ModElement {
	public InfinityAndOresToolsAndArmorsTabItemGroup(InfinityAndOresModElements instance) {
		super(instance, 211);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabinfinity_and_ores_tools_and_armors_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlitchedSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
