
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.infinityores.procedures.AmendoimStewProcedureProcedure;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@InfinityAndOresModElements.ModElement.Tag
public class AmendoimStewItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:amendoim_stew")
	public static final Item block = null;
	public AmendoimStewItem(InfinityAndOresModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).food((new Food.Builder()).hunger(6).saturation(1.6f).build()));
			setRegistryName("amendoim_stew");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"This food doesn't give a bowl when eaten as of now. This will change once Infinity & Ores will be updated to MCreator 2020.5."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AmendoimStewProcedureProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
