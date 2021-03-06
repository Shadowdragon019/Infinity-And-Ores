
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.StrippedGhostwoodWoodBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class StrippedGhostwoodWoodFuelFuel extends InfinityAndOresModElements.ModElement {
	public StrippedGhostwoodWoodFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 510);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(StrippedGhostwoodWoodBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
