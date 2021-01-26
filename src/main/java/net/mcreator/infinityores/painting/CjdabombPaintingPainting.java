
package net.mcreator.infinityores.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class CjdabombPaintingPainting extends InfinityAndOresModElements.ModElement {
	public CjdabombPaintingPainting(InfinityAndOresModElements instance) {
		super(instance, 580);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("cjdabomb_painting"));
	}
}
