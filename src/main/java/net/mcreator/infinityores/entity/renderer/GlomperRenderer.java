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

import net.mcreator.infinityores.entity.GlomperEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GlomperRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GlomperEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelchomper(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("infinity_and_ores:textures/glomper.png");
					}
				};
			});
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
			this.TopRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.TopMouth.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.BottomLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.BottomRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.TopLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
