
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.GhostwoodDoorBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class GhostwoodDoorFuelFuel extends InfinityAndOresModElements.ModElement {
	public GhostwoodDoorFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 527);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(GhostwoodDoorBlock.block, (int) (1)).getItem())
			event.setBurnTime(200);
	}
}
