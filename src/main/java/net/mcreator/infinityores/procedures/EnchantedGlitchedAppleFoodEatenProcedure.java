package net.mcreator.infinityores.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.item.EnchantedGlitchedAppleItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class EnchantedGlitchedAppleFoodEatenProcedure extends InfinityAndOresModElements.ModElement {
	public EnchantedGlitchedAppleFoodEatenProcedure(InfinityAndOresModElements instance) {
		super(instance, 433);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EnchantedGlitchedAppleFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.RESISTANCE, (int) (3600 + ((new java.util.Random()).nextInt((int) 2400 + 1))), (int) 3));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.REGENERATION, (int) (3600 + ((new java.util.Random()).nextInt((int) 2400 + 1))), (int) 2));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.STRENGTH, (int) (3600 + ((new java.util.Random()).nextInt((int) 2400 + 1))), (int) 3));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.ABSORPTION, (int) (3600 + ((new java.util.Random()).nextInt((int) 2400 + 1))), (int) 4));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(
					new EffectInstance(Effects.HEALTH_BOOST, (int) (3600 + ((new java.util.Random()).nextInt((int) 2400 + 1))), (int) 5));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(EnchantedGlitchedAppleItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
