
package net.mcreator.infinityores.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.infinityores.item.OpristoniumGemItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class InfinityAndOresItemsTabItemGroup extends InfinityAndOresModElements.ModElement {
	public InfinityAndOresItemsTabItemGroup(InfinityAndOresModElements instance) {
		super(instance, 199);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabinfinity_and_ores_items_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OpristoniumGemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
