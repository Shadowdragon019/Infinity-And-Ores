
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.AmendoimTrapdoorBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimTrapdoorFuelFuel extends InfinityAndOresModElements.ModElement {
	public AmendoimTrapdoorFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 283);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(AmendoimTrapdoorBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
