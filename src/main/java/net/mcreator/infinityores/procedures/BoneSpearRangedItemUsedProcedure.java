package net.mcreator.infinityores.procedures;

@InfinityAndOresModElements.ModElement.Tag
public class BoneSpearRangedItemUsedProcedure extends InfinityAndOresModElements.ModElement {

	public BoneSpearRangedItemUsedProcedure(InfinityAndOresModElements instance) {
		super(instance, 492);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BoneSpearRangedItemUsed!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown((new ItemStack(BoneSpearItem.block, (int) (1))).getItem(), (int) 80);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown((new ItemStack(ReinforcedBoneSpearItem.block, (int) (1))).getItem(), (int) 120);

	}

}
