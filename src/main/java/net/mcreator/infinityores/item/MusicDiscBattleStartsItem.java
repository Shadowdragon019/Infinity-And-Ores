
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.infinityores.itemgroup.InfinityAndOresItemsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class MusicDiscBattleStartsItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:music_disc_battle_starts")
	public static final Item block = null;
	public MusicDiscBattleStartsItem(InfinityAndOresModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, InfinityAndOresModElements.sounds.get(new ResourceLocation("infinity_and_ores:battle_starts")),
					new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_battle_starts");
		}
	}
}
