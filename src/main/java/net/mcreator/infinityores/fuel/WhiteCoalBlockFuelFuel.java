
package net.mcreator.infinityores.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.infinityores.block.WhiteCoalBlockBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class WhiteCoalBlockFuelFuel extends InfinityAndOresModElements.ModElement {
	public WhiteCoalBlockFuelFuel(InfinityAndOresModElements instance) {
		super(instance, 307);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(WhiteCoalBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(20000);
	}
}
