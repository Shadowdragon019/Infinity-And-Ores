
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.GhostwoodSlabBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class GhostwoodSlabFuelFuel extends InfinityAndOresModElements.ModElement {
	public GhostwoodSlabFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 517);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(GhostwoodSlabBlock.block, (int) (1)).getItem())
			event.setBurnTime(150);
	}
}
