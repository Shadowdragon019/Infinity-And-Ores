
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.AmendoimSlabBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimSlabFuelFuel extends InfinityAndOresModElements.ModElement {
	public AmendoimSlabFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 293);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(AmendoimSlabBlock.block, (int) (1)).getItem())
			event.setBurnTime(150);
	}
}
