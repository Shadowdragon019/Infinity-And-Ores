
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.infinityores.itemgroup.InfinityAndOresItemsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class MusicDiscSpiritsItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:music_disc_spirits")
	public static final Item block = null;
	public MusicDiscSpiritsItem(InfinityAndOresModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, InfinityAndOresModElements.sounds.get(new ResourceLocation("infinity_and_ores:spirits")),
					new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_spirits");
		}
	}
}
