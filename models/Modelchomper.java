// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelchomper extends EntityModel<Entity> {
	private final ModelRenderer Mouth;
	private final ModelRenderer bone;
	private final ModelRenderer Teeth;
	private final ModelRenderer bb_main;

	public Modelchomper() {
		textureWidth = 64;
		textureHeight = 64;

		Mouth = new ModelRenderer(this);
		Mouth.setRotationPoint(8.0F, 15.0F, -8.0F);
		Mouth.setTextureOffset(0, 0).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -4.0F, 1.0F);
		Mouth.addChild(bone);
		setRotationAngle(bone, -0.2618F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 20).addBox(-16.0F, -4.0F, -0.5F, 16.0F, 4.0F, 16.0F, 0.0F, false);

		Teeth = new ModelRenderer(this);
		Teeth.setRotationPoint(-16.0F, 3.1566F, -0.1895F);
		bone.addChild(Teeth);
		setRotationAngle(Teeth, 0.0F, 0.0F, -3.1416F);
		Teeth.setTextureOffset(0, 40).addBox(-15.0F, -0.1022F, 0.7765F, 14.0F, 3.0F, 15.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(48, 40).addBox(3.0F, -5.0F, -7.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(48, 40).addBox(-7.0F, -5.0F, -7.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(48, 40).addBox(-7.0F, -5.0F, 3.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(48, 40).addBox(3.0F, -5.0F, 3.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Mouth.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}