
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.item.WhiteCoalItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class WhiteCoalFuelFuel extends InfinityAndOresModElements.ModElement {
	public WhiteCoalFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 293);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(WhiteCoalItem.block, (int) (1)).getItem())
			event.setBurnTime(2000);
	}
}
