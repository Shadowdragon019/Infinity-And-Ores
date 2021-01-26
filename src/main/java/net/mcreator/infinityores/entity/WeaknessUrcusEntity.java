
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

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.infinityores.procedures.WeaknessUrcusHitProcedureProcedure;
import net.mcreator.infinityores.procedures.WeaknessUrcusCollideProcedureProcedure;
import net.mcreator.infinityores.item.VirusCoreItem;
import net.mcreator.infinityores.InfinityAndOresModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@InfinityAndOresModElements.ModElement.Tag
public class WeaknessUrcusEntity extends InfinityAndOresModElements.ModElement {
	public static EntityType entity = null;
	public WeaknessUrcusEntity(InfinityAndOresModElements instance) {
		super(instance, 145);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.4f, 0.4f))
						.build("weakness_urcus").setRegistryName("weakness_urcus");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -15592942, -10000537, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("weakness_urcus_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("infinity_and_ores:mantle_amendoim_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("infinity_and_ores:mantle_realms").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(entity, 20, 1, 4));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelvirus_mob(), 0.4f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("infinity_and_ores:textures/urcus_weakness.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
		ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.4, 20) {
				@Override
				protected Vector3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vector3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(VirusCoreItem.block, (int) (1)));
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
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("sourceentity", sourceentity);
				WeaknessUrcusHitProcedureProcedure.executeProcedure($_dependencies);
			}
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				WeaknessUrcusCollideProcedureProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelvirus_mob extends EntityModel<Entity> {
		private final ModelRenderer Front11;
		private final ModelRenderer Front12;
		private final ModelRenderer Front9;
		private final ModelRenderer Front10;
		private final ModelRenderer Front7;
		private final ModelRenderer Front8;
		private final ModelRenderer Front2;
		private final ModelRenderer Front3;
		private final ModelRenderer Front4;
		private final ModelRenderer Front6;
		private final ModelRenderer Front5;
		private final ModelRenderer Front;
		private final ModelRenderer bb_main;
		public Modelvirus_mob() {
			textureWidth = 16;
			textureHeight = 16;
			Front11 = new ModelRenderer(this);
			Front11.setRotationPoint(2.0F, 18.0F, 1.0F);
			Front12 = new ModelRenderer(this);
			Front12.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front11.addChild(Front12);
			Front12.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -2.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front12.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front9 = new ModelRenderer(this);
			Front9.setRotationPoint(2.0F, 14.0F, -1.0F);
			Front10 = new ModelRenderer(this);
			Front10.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front9.addChild(Front10);
			Front10.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front10.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, true);
			Front7 = new ModelRenderer(this);
			Front7.setRotationPoint(2.0F, 18.0F, -1.0F);
			Front8 = new ModelRenderer(this);
			Front8.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front7.addChild(Front8);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front8.setTextureOffset(0, 0).addBox(0.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front2 = new ModelRenderer(this);
			Front2.setRotationPoint(-3.0F, 18.0F, -1.0F);
			Front3 = new ModelRenderer(this);
			Front3.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front2.addChild(Front3);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front3.setTextureOffset(0, 0).addBox(0.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			Front4 = new ModelRenderer(this);
			Front4.setRotationPoint(-1.0F, 14.0F, 2.0F);
			Front6 = new ModelRenderer(this);
			Front6.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front4.addChild(Front6);
			Front6.setTextureOffset(0, 0).addBox(3.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(2.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front6.setTextureOffset(0, 0).addBox(3.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front5 = new ModelRenderer(this);
			Front5.setRotationPoint(-1.0F, 14.0F, -3.0F);
			Front = new ModelRenderer(this);
			Front.setRotationPoint(0.0F, 0.0F, 0.0F);
			Front5.addChild(Front);
			Front.setTextureOffset(0, 0).addBox(3.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(2.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(-1.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			Front.setTextureOffset(0, 0).addBox(3.0F, 2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Front11.render(matrixStack, buffer, packedLight, packedOverlay);
			Front9.render(matrixStack, buffer, packedLight, packedOverlay);
			Front7.render(matrixStack, buffer, packedLight, packedOverlay);
			Front2.render(matrixStack, buffer, packedLight, packedOverlay);
			Front4.render(matrixStack, buffer, packedLight, packedOverlay);
			Front5.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
