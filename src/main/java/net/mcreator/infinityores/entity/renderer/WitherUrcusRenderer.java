package net.mcreator.infinityores.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.infinityores.entity.WitherUrcusEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WitherUrcusRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(WitherUrcusEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelvirus_mob(), 0.4f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("infinity_and_ores:textures/urcus_wither.png");
					}
				};
			});
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
