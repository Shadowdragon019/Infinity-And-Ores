package net.mcreator.infinityores.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.infinityores.item.EndesuliteArmorItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;
import java.util.Iterator;

@InfinityAndOresModElements.ModElement.Tag
public class DimensionalGuardianProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public DimensionalGuardianProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 232);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DimensionalGuardianProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteArmorItem.helmet, (int) (1)))
				: false)
				&& (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteArmorItem.body, (int) (1)))
						: false)
						&& (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteArmorItem.legs, (int) (1)))
								: false)
								&& ((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteArmorItem.boots, (int) (1)))
										: false))))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("infinity_and_ores:dimensional_guardian"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
