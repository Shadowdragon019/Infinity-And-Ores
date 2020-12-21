
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.StrippedAmendoimLogBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class StrippedAmendoimLogFuelFuel extends InfinityAndOresModElements.ModElement {
	public StrippedAmendoimLogFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 289);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(StrippedAmendoimLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
