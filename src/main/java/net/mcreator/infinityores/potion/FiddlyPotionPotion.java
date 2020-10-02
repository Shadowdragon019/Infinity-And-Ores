
package net.mcreator.infinityores.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class FiddlyPotionPotion extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:fiddly_potion")
	public static final Effect potion = null;
	@ObjectHolder("infinity_and_ores:fiddly_potion")
	public static final Potion potionType = null;
	public FiddlyPotionPotion(InfinityAndOresModElements instance) {
		super(instance, 376);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(potion, 0));
			setRegistryName("fiddly_potion");
		}
	}

	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.NEUTRAL, -13421569);
			setRegistryName("fiddly_potion");
			potionIcon = new ResourceLocation("infinity_and_ores:textures/opriston.png");
		}

		@Override
		public String getName() {
			return "effect.fiddly_potion";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
