package net.mcreator.infinityores.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class WeaknessUrcusCollideProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public WeaknessUrcusCollideProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 318);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WeaknessUrcusCollideProcedure!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure WeaknessUrcusCollideProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) 0);
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 100, (int) 0));
	}
}
