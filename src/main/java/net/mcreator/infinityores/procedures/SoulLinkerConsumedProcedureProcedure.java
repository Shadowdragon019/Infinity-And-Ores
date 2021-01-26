package net.mcreator.infinityores.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.item.UnchargedSoulLinkerItem;
import net.mcreator.infinityores.item.ChargedSoulLinkerItem;
import net.mcreator.infinityores.InfinityAndOresModElements;
import net.mcreator.infinityores.InfinityAndOresMod;

import java.util.Map;

@InfinityAndOresModElements.ModElement.Tag
public class SoulLinkerConsumedProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public SoulLinkerConsumedProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 538);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency entity for procedure SoulLinkerConsumedProcedure!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				InfinityAndOresMod.LOGGER.warn("Failed to load dependency itemstack for procedure SoulLinkerConsumedProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ChargedSoulLinkerItem.block, (int) (1)).getItem()) && ((((itemstack)).getDamage()) == 1))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(UnchargedSoulLinkerItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
	}
}
