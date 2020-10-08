package net.mcreator.infinityores.procedures;

@InfinityAndOresModElements.ModElement.Tag
public class GlomperToothArmorBodyTickEventProcedure extends InfinityAndOresModElements.ModElement {

	public GlomperToothArmorBodyTickEventProcedure(InfinityAndOresModElements instance) {
		super(instance, 491);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GlomperToothArmorBodyTickEvent!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 20, (int) 0));

	}

}
