
package net.mcreator.infinityores.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.procedures.PotionOfDecayPotionStartedappliedProcedure;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;
import java.util.HashMap;

@InfinityAndOresModElements.ModElement.Tag
public class PotionOfDecayPotion extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:potion_of_decay")
	public static final Effect potion = null;
	@ObjectHolder("infinity_and_ores:potion_of_decay")
	public static final Potion potionType = null;
	public PotionOfDecayPotion(InfinityAndOresModElements instance) {
		super(instance, 409);
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
			super(new EffectInstance(potion, 800));
			setRegistryName("potion_of_decay");
		}
	}

	public static class EffectCustom extends Effect {
		private final ResourceLocation potionIcon;
		public EffectCustom() {
			super(EffectType.HARMFUL, -15135475);
			setRegistryName("potion_of_decay");
			potionIcon = new ResourceLocation("infinity_and_ores:textures/wither.png");
		}

		@Override
		public String getName() {
			return "effect.potion_of_decay";
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
		public void affectEntity(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PotionOfDecayPotionStartedappliedProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
