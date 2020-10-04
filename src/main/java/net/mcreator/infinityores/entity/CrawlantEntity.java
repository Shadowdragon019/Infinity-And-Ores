
package net.mcreator.infinityores.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;

import net.mcreator.infinityores.InfinityAndOresModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@InfinityAndOresModElements.ModElement.Tag
public class CrawlantEntity extends InfinityAndOresModElements.ModElement {
	public static EntityType entity = null;
	public CrawlantEntity(InfinityAndOresModElements instance) {
		super(instance, 116);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.8f, 0.8f)).build("crawlant")
						.setRegistryName("crawlant");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -9153748, -14149366, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("crawlant"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("infinity_and_ores:spiky_plateau")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 15, 3, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcrawler_ant(), 1.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("infinity_and_ores:textures/crawlant.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, UrcusEntity.CustomEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), 0.15f,
					1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcrawler_ant extends EntityModel<Entity> {
		private final ModelRenderer Creature1;
		private final ModelRenderer Legs2;
		private final ModelRenderer Left4;
		private final ModelRenderer LeftLeg5;
		private final ModelRenderer Top5;
		private final ModelRenderer Bottom5;
		private final ModelRenderer LeftLeg6;
		private final ModelRenderer Top6;
		private final ModelRenderer Bottom6;
		private final ModelRenderer Right4;
		private final ModelRenderer LeftLeg7;
		private final ModelRenderer Top7;
		private final ModelRenderer Bottom7;
		private final ModelRenderer LeftLeg8;
		private final ModelRenderer Top8;
		private final ModelRenderer Bottom8;
		private final ModelRenderer Body2;
		private final ModelRenderer Dart2;
		private final ModelRenderer Abdomen2;
		private final ModelRenderer Mouth2;
		private final ModelRenderer Left5;
		private final ModelRenderer Front3;
		private final ModelRenderer Right5;
		private final ModelRenderer Front4;
		private final ModelRenderer Antennas2;
		private final ModelRenderer bone2;
		private final ModelRenderer Left6;
		private final ModelRenderer Right6;
		private final ModelRenderer Back;
		private final ModelRenderer Top;
		private final ModelRenderer Left;
		private final ModelRenderer Right;
		private final ModelRenderer bone;
		public Modelcrawler_ant() {
			textureWidth = 64;
			textureHeight = 64;
			Creature1 = new ModelRenderer(this);
			Creature1.setRotationPoint(0.0F, 14.0F, 0.0F);
			Legs2 = new ModelRenderer(this);
			Legs2.setRotationPoint(-3.0F, 1.0F, -13.0F);
			Creature1.addChild(Legs2);
			Left4 = new ModelRenderer(this);
			Left4.setRotationPoint(0.0F, 0.0F, 0.0F);
			Legs2.addChild(Left4);
			LeftLeg5 = new ModelRenderer(this);
			LeftLeg5.setRotationPoint(-1.0F, 0.0F, 0.0F);
			Left4.addChild(LeftLeg5);
			Top5 = new ModelRenderer(this);
			Top5.setRotationPoint(0.0F, 0.0F, 0.0F);
			LeftLeg5.addChild(Top5);
			setRotationAngle(Top5, 0.0F, 0.0F, -0.7854F);
			Top5.setTextureOffset(0, 34).addBox(3.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
			Bottom5 = new ModelRenderer(this);
			Bottom5.setRotationPoint(30.0F, 18.0F, 0.0F);
			LeftLeg5.addChild(Bottom5);
			setRotationAngle(Bottom5, 0.0F, 0.0F, 1.2217F);
			Bottom5.setTextureOffset(0, 0).addBox(-28.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
			LeftLeg6 = new ModelRenderer(this);
			LeftLeg6.setRotationPoint(0.0F, 0.0F, 12.0F);
			Left4.addChild(LeftLeg6);
			Top6 = new ModelRenderer(this);
			Top6.setRotationPoint(0.0F, 0.0F, 0.0F);
			LeftLeg6.addChild(Top6);
			setRotationAngle(Top6, 0.0F, 0.0F, -0.7854F);
			Top6.setTextureOffset(0, 34).addBox(3.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
			Bottom6 = new ModelRenderer(this);
			Bottom6.setRotationPoint(30.0F, 18.0F, 0.0F);
			LeftLeg6.addChild(Bottom6);
			setRotationAngle(Bottom6, 0.0F, 0.0F, 1.2217F);
			Bottom6.setTextureOffset(0, 0).addBox(-28.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
			Right4 = new ModelRenderer(this);
			Right4.setRotationPoint(6.0F, 0.0F, 0.0F);
			Legs2.addChild(Right4);
			LeftLeg7 = new ModelRenderer(this);
			LeftLeg7.setRotationPoint(1.0F, 0.0F, 0.0F);
			Right4.addChild(LeftLeg7);
			Top7 = new ModelRenderer(this);
			Top7.setRotationPoint(0.0F, 0.0F, 0.0F);
			LeftLeg7.addChild(Top7);
			setRotationAngle(Top7, 0.0F, 0.0F, 0.7854F);
			Top7.setTextureOffset(0, 34).addBox(-17.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, true);
			Bottom7 = new ModelRenderer(this);
			Bottom7.setRotationPoint(-30.0F, 18.0F, 0.0F);
			LeftLeg7.addChild(Bottom7);
			setRotationAngle(Bottom7, 0.0F, 0.0F, -1.2217F);
			Bottom7.setTextureOffset(0, 0).addBox(10.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, true);
			LeftLeg8 = new ModelRenderer(this);
			LeftLeg8.setRotationPoint(0.0F, 0.0F, 12.0F);
			Right4.addChild(LeftLeg8);
			Top8 = new ModelRenderer(this);
			Top8.setRotationPoint(0.0F, 0.0F, 0.0F);
			LeftLeg8.addChild(Top8);
			setRotationAngle(Top8, 0.0F, 0.0F, 0.7854F);
			Top8.setTextureOffset(0, 34).addBox(-17.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, true);
			Bottom8 = new ModelRenderer(this);
			Bottom8.setRotationPoint(-30.0F, 18.0F, 0.0F);
			LeftLeg8.addChild(Bottom8);
			setRotationAngle(Bottom8, 0.0F, 0.0F, -1.2217F);
			Bottom8.setTextureOffset(0, 0).addBox(10.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, true);
			Body2 = new ModelRenderer(this);
			Body2.setRotationPoint(4.0F, 2.0F, 6.0F);
			Creature1.addChild(Body2);
			Body2.setTextureOffset(0, 44).addBox(-7.0F, -4.0F, -14.0F, 6.0F, 6.0F, 14.0F, 0.0F, false);
			Dart2 = new ModelRenderer(this);
			Dart2.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body2.addChild(Dart2);
			setRotationAngle(Dart2, 0.3054F, 0.0F, 0.0F);
			Abdomen2 = new ModelRenderer(this);
			Abdomen2.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body2.addChild(Abdomen2);
			setRotationAngle(Abdomen2, 0.3054F, 0.0F, 0.0F);
			Abdomen2.setTextureOffset(0, 11).addBox(-8.0F, -5.145F, -0.9F, 8.0F, 8.0F, 14.0F, 0.0F, false);
			Mouth2 = new ModelRenderer(this);
			Mouth2.setRotationPoint(4.0F, 0.0F, -13.0F);
			Creature1.addChild(Mouth2);
			Left5 = new ModelRenderer(this);
			Left5.setRotationPoint(-6.0F, 0.0F, 0.0F);
			Mouth2.addChild(Left5);
			Left5.setTextureOffset(57, 61).addBox(0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			Front3 = new ModelRenderer(this);
			Front3.setRotationPoint(-1.0F, 0.0F, 12.921F);
			Left5.addChild(Front3);
			setRotationAngle(Front3, 0.0F, -0.1745F, 0.0F);
			Front3.setTextureOffset(58, 57).addBox(-0.7385F, 2.0F, -11.9324F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			Right5 = new ModelRenderer(this);
			Right5.setRotationPoint(-2.0F, 0.0F, 0.0F);
			Mouth2.addChild(Right5);
			Right5.setTextureOffset(57, 61).addBox(-1.0F, 2.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Front4 = new ModelRenderer(this);
			Front4.setRotationPoint(1.0F, 0.0F, 12.921F);
			Right5.addChild(Front4);
			setRotationAngle(Front4, 0.0F, 0.1745F, 0.0F);
			Front4.setTextureOffset(58, 57).addBox(-0.2615F, 2.0F, -11.9324F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Antennas2 = new ModelRenderer(this);
			Antennas2.setRotationPoint(3.0F, 1.0F, -13.0F);
			Creature1.addChild(Antennas2);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-3.0F, -9.0F, -1.0F);
			Antennas2.addChild(bone2);
			Left6 = new ModelRenderer(this);
			Left6.setRotationPoint(-5.0F, 0.0F, 0.0F);
			bone2.addChild(Left6);
			setRotationAngle(Left6, 0.0F, -0.6545F, -1.5708F);
			Left6.setTextureOffset(50, 48).addBox(-1.2066F, 2.0F, 4.25F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Right6 = new ModelRenderer(this);
			Right6.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(Right6);
			setRotationAngle(Right6, 0.0F, -0.6545F, -1.5708F);
			Right6.setTextureOffset(50, 48).addBox(-1.2066F, 2.0F, 4.25F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Back = new ModelRenderer(this);
			Back.setRotationPoint(0.0F, -26.0596F, 27.223F);
			Antennas2.addChild(Back);
			Top = new ModelRenderer(this);
			Top.setRotationPoint(0.0F, 16.0596F, -24.223F);
			Back.addChild(Top);
			setRotationAngle(Top, 0.7854F, 0.0F, 0.0F);
			Top.setTextureOffset(44, 0).addBox(-4.0F, 7.8995F, -2.4142F, 2.0F, 2.0F, 8.0F, 0.0F, false);
			Top.setTextureOffset(34, 10).addBox(-4.0F, 19.8995F, 15.5858F, 2.0F, 2.0F, 13.0F, 0.0F, false);
			Left = new ModelRenderer(this);
			Left.setRotationPoint(20.4307F, 23.0F, -4.1067F);
			Back.addChild(Left);
			setRotationAngle(Left, -0.48F, 0.0F, 1.5708F);
			Left.setTextureOffset(34, 10).addBox(-2.0F, 19.8995F, 16.5858F, 2.0F, 2.0F, 13.0F, 0.0F, false);
			Right = new ModelRenderer(this);
			Right.setRotationPoint(-26.4307F, 23.0F, -4.1067F);
			Back.addChild(Right);
			setRotationAngle(Right, -0.48F, 0.0F, -1.5708F);
			Right.setTextureOffset(34, 10).addBox(0.0F, 19.8995F, 16.5858F, 2.0F, 2.0F, 13.0F, 0.0F, true);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 16.0596F, -24.223F);
			Back.addChild(bone);
			setRotationAngle(bone, -0.7854F, 0.0F, 0.0F);
			bone.setTextureOffset(34, 10).addBox(-4.0F, -14.55F, 26.1924F, 2.0F, 2.0F, 13.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Creature1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
