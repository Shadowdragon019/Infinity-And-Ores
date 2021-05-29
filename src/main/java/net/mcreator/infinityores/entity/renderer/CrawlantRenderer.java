package net.mcreator.infinityores.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.infinityores.entity.CrawlantEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CrawlantRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CrawlantEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcrawler_ant(), 1.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("infinity_and_ores:textures/crawlant.png");
					}
				};
			});
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
			LeftLeg5.setRotationPoint(6.0F, 1.0F, 9.0F);
			Left4.addChild(LeftLeg5);
			Top5 = new ModelRenderer(this);
			Top5.setRotationPoint(-7.0F, -1.0F, -9.0F);
			LeftLeg5.addChild(Top5);
			setRotationAngle(Top5, 0.0F, 0.0F, -0.7854F);
			Top5.setTextureOffset(0, 34).addBox(3.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
			Bottom5 = new ModelRenderer(this);
			Bottom5.setRotationPoint(23.0F, 17.0F, -9.0F);
			LeftLeg5.addChild(Bottom5);
			setRotationAngle(Bottom5, 0.0F, 0.0F, 1.2217F);
			Bottom5.setTextureOffset(0, 0).addBox(-28.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
			LeftLeg6 = new ModelRenderer(this);
			LeftLeg6.setRotationPoint(7.0F, 0.0F, 21.0F);
			Left4.addChild(LeftLeg6);
			Top6 = new ModelRenderer(this);
			Top6.setRotationPoint(-7.0F, 0.0F, -9.0F);
			LeftLeg6.addChild(Top6);
			setRotationAngle(Top6, 0.0F, 0.0F, -0.7854F);
			Top6.setTextureOffset(0, 34).addBox(3.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, false);
			Bottom6 = new ModelRenderer(this);
			Bottom6.setRotationPoint(23.0F, 18.0F, -9.0F);
			LeftLeg6.addChild(Bottom6);
			setRotationAngle(Bottom6, 0.0F, 0.0F, 1.2217F);
			Bottom6.setTextureOffset(0, 0).addBox(-28.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
			Right4 = new ModelRenderer(this);
			Right4.setRotationPoint(6.0F, 0.0F, 0.0F);
			Legs2.addChild(Right4);
			LeftLeg7 = new ModelRenderer(this);
			LeftLeg7.setRotationPoint(-6.0F, 0.0F, 9.0F);
			Right4.addChild(LeftLeg7);
			Top7 = new ModelRenderer(this);
			Top7.setRotationPoint(7.0F, 0.0F, -9.0F);
			LeftLeg7.addChild(Top7);
			setRotationAngle(Top7, 0.0F, 0.0F, 0.7854F);
			Top7.setTextureOffset(0, 34).addBox(-17.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, true);
			Bottom7 = new ModelRenderer(this);
			Bottom7.setRotationPoint(-23.0F, 18.0F, -9.0F);
			LeftLeg7.addChild(Bottom7);
			setRotationAngle(Bottom7, 0.0F, 0.0F, -1.2217F);
			Bottom7.setTextureOffset(0, 0).addBox(10.65F, 3.405F, 8.0F, 18.0F, 2.0F, 2.0F, 0.0F, true);
			LeftLeg8 = new ModelRenderer(this);
			LeftLeg8.setRotationPoint(-7.0F, 1.0F, 21.0F);
			Right4.addChild(LeftLeg8);
			Top8 = new ModelRenderer(this);
			Top8.setRotationPoint(7.0F, -1.0F, -9.0F);
			LeftLeg8.addChild(Top8);
			setRotationAngle(Top8, 0.0F, 0.0F, 0.7854F);
			Top8.setTextureOffset(0, 34).addBox(-17.5061F, 4.5355F, 8.0F, 14.0F, 2.0F, 2.0F, 0.0F, true);
			Bottom8 = new ModelRenderer(this);
			Bottom8.setRotationPoint(-23.0F, 17.0F, -9.0F);
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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Creature1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.LeftLeg6.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftLeg5.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftLeg8.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
