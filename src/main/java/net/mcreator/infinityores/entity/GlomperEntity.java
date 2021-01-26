
package net.mcreator.infinityores.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.infinityores.item.GlomperToothItem;
import net.mcreator.infinityores.item.AmendoimWartItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@InfinityAndOresModElements.ModElement.Tag
public class GlomperEntity extends InfinityAndOresModElements.ModElement {
	public static EntityType entity = null;
	public GlomperEntity(InfinityAndOresModElements instance) {
		super(instance, 149);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("glomper")
						.setRegistryName("glomper");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -6750055, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("glomper_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("infinity_and_ores:spiky_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 3));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelchomper(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("infinity_and_ores:textures/glomper.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends AnimalEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
			this.goalSelector.addGoal(5,
					new TemptGoal(this, 1, Ingredient.fromItems(new ItemStack(AmendoimWartItem.block, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(6, new AvoidEntityGoal(this, CrawlantEntity.CustomEntity.class, (float) 6, 1, 1.2));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(GlomperToothItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(serverWorld);
			retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(AmendoimWartItem.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelchomper extends EntityModel<Entity> {
		private final ModelRenderer Mouth;
		private final ModelRenderer BottomMouth;
		private final ModelRenderer TopMouth;
		private final ModelRenderer Teeth;
		private final ModelRenderer Legs;
		private final ModelRenderer TopLeftLeg;
		private final ModelRenderer BottomLeftLeg;
		private final ModelRenderer BottomRightLeg;
		private final ModelRenderer TopRightLeg;
		public Modelchomper() {
			textureWidth = 64;
			textureHeight = 64;
			Mouth = new ModelRenderer(this);
			Mouth.setRotationPoint(8.0F, 15.0F, -8.0F);
			BottomMouth = new ModelRenderer(this);
			BottomMouth.setRotationPoint(0.0F, 4.0F, 0.0F);
			Mouth.addChild(BottomMouth);
			BottomMouth.setTextureOffset(0, 0).addBox(-16.0F, -4.0F, 0.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
			TopMouth = new ModelRenderer(this);
			TopMouth.setRotationPoint(-8.0F, 1.0F, 16.0F);
			Mouth.addChild(TopMouth);
			TopMouth.setTextureOffset(0, 20).addBox(-8.0F, -4.9F, -16.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
			Teeth = new ModelRenderer(this);
			Teeth.setRotationPoint(8.0F, 0.9133F, -16.9582F);
			TopMouth.addChild(Teeth);
			setRotationAngle(Teeth, 3.1416F, 0.0F, 0.0F);
			Teeth.setTextureOffset(0, 40).addBox(-15.0F, -0.9313F, -17.0418F, 14.0F, 4.0F, 15.0F, 0.0F, false);
			Legs = new ModelRenderer(this);
			Legs.setRotationPoint(7.0F, 24.0F, -7.0F);
			TopLeftLeg = new ModelRenderer(this);
			TopLeftLeg.setRotationPoint(-2.0F, -5.0F, 2.0F);
			Legs.addChild(TopLeftLeg);
			TopLeftLeg.setTextureOffset(48, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			BottomLeftLeg = new ModelRenderer(this);
			BottomLeftLeg.setRotationPoint(-12.0F, -5.0F, 12.0F);
			Legs.addChild(BottomLeftLeg);
			BottomLeftLeg.setTextureOffset(48, 40).addBox(8.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			BottomRightLeg = new ModelRenderer(this);
			BottomRightLeg.setRotationPoint(-2.0F, -5.0F, 12.0F);
			Legs.addChild(BottomRightLeg);
			BottomRightLeg.setTextureOffset(48, 40).addBox(-12.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			TopRightLeg = new ModelRenderer(this);
			TopRightLeg.setRotationPoint(-12.0F, -5.0F, 2.0F);
			Legs.addChild(TopRightLeg);
			TopRightLeg.setTextureOffset(48, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Mouth.render(matrixStack, buffer, packedLight, packedOverlay);
			Legs.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.TopMouth.rotateAngleY = f4 / (180F / (float) Math.PI);
		}
	}
}
