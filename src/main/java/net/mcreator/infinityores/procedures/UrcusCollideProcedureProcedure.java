package net.mcreator.infinityores.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.InfinityAndOresModElements;
import net.mcreator.infinityores.InfinityAndOresMod;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class UrcusCollideProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public UrcusCollideProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 344);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency entity for procedure UrcusCollideProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth((float) 0);
	}
}
