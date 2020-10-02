package net.mcreator.infinityores.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class WeaknessUrcusHitProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public WeaknessUrcusHitProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 322);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WeaknessUrcusHitProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 100, (int) 0));
	}
}
