
package net.mcreator.infinityores.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.infinityores.itemgroup.InfinityAndOresToolsAndArmorsTabItemGroup;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class EndesuliteArmorItem extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:endesulite_helmet")
	public static final Item helmet = null;
	@ObjectHolder("infinity_and_ores:endesulite_chestplate")
	public static final Item body = null;
	@ObjectHolder("infinity_and_ores:endesulite_leggings")
	public static final Item legs = null;
	@ObjectHolder("infinity_and_ores:endesulite_boots")
	public static final Item boots = null;
	public EndesuliteArmorItem(InfinityAndOresModElements instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 55;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{6, 9, 10, 6}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 25;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_generic"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndesuliteCrystalItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "endesulite";
			}

			@Override
			public float getToughness() {
				return 4f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD,
				new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "infinity_and_ores:textures/models/armor/ezesulite___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("endesulite_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST,
				new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "infinity_and_ores:textures/models/armor/ezesulite___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("endesulite_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS,
				new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "infinity_and_ores:textures/models/armor/ezesulite___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("endesulite_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET,
				new Item.Properties().group(InfinityAndOresToolsAndArmorsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "infinity_and_ores:textures/models/armor/ezesulite___layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("endesulite_boots"));
	}
}
