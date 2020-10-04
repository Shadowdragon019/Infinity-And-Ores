package net.mcreator.infinityores.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.infinityores.item.EndesuliteSwordItem;
import net.mcreator.infinityores.item.EndesuliteShovelItem;
import net.mcreator.infinityores.item.EndesulitePickaxeItem;
import net.mcreator.infinityores.item.EndesuliteHoeItem;
import net.mcreator.infinityores.item.EndesuliteAxeItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;
import java.util.Iterator;

@InfinityAndOresModElements.ModElement.Tag
public class LunarPowerProcedureProcedure extends InfinityAndOresModElements.ModElement {
	public LunarPowerProcedureProcedure(InfinityAndOresModElements instance) {
		super(instance, 213);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LunarPowerProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteSwordItem.block, (int) (1)))
				: false)
				|| (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesulitePickaxeItem.block, (int) (1)))
						: false)
						|| (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteAxeItem.block, (int) (1)))
								: false)
								|| (((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteShovelItem.block, (int) (1)))
										: false)
										|| ((entity instanceof PlayerEntity)
												? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(EndesuliteHoeItem.block, (int) (1)))
												: false)))))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("infinity_and_ores:lunar_power"));
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
