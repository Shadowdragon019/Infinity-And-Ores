package net.mcreator.infinityores.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.item.ReinforcedBoneSpearItem;
import net.mcreator.infinityores.item.BoneSpearItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class BoneSpearRangedItemUsedProcedure extends InfinityAndOresModElements.ModElement {
	public BoneSpearRangedItemUsedProcedure(InfinityAndOresModElements instance) {
		super(instance, 504);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
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
