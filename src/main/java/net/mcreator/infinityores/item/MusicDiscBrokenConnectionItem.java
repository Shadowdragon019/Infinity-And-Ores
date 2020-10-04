
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.infinityores.itemgroup.InfinityAndOresItemsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.List;

@InfinityAndOresModElements.ModElement.Tag
public class MusicDiscBrokenConnectionItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:music_disc_broken_connection")
	public static final Item block = null;
	public MusicDiscBrokenConnectionItem(InfinityAndOresModElements instance) {
		super(instance, 449);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, InfinityAndOresModElements.sounds.get(new ResourceLocation("infinity_and_ores:broken_connection")),
					new Item.Properties().group(InfinityAndOresItemsTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_broken_connection");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("WARNING: If you play this song in a YouTube video"));
			list.add(new StringTextComponent("you might get demonetized."));
		}
	}
}
