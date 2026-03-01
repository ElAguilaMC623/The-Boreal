package net.elaguilamc623.the_boreal.entities.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elaguilamc623.the_boreal.entities.animations.BorealAnimationDefinitions;
import net.elaguilamc623.the_boreal.entities.custom.BorealGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;

public class BorealGolemModel extends HierarchicalModel<BorealGolemEntity> {

    private final AnimationState attackState = new AnimationState();

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "boreal_warrior"), "main");
	private final ModelPart boreal_golem;
	private final ModelPart legs;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart trunk;
	private final ModelPart head;
	private final ModelPart arms;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public BorealGolemModel(ModelPart root) {
		this.boreal_golem = root.getChild("boreal_golem");
		this.legs = this.boreal_golem.getChild("legs");
		this.right_leg = this.legs.getChild("right_leg");
		this.left_leg = this.legs.getChild("left_leg");
		this.trunk = this.boreal_golem.getChild("trunk");
		this.head = this.boreal_golem.getChild("head");
		this.arms = this.boreal_golem.getChild("arms");
		this.left_arm = this.arms.getChild("left_arm");
		this.right_arm = this.arms.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition boreal_golem = partdefinition.addOrReplaceChild("boreal_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = boreal_golem.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 28).addBox(-6.0F, -13.0F, -3.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 46).addBox(2.0F, -12.0F, -3.0F, 4.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition trunk = boreal_golem.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -30.0F, -5.0F, 14.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = boreal_golem.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-5.0F, -11.0F, -6.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 47).addBox(-4.0F, -3.0F, -6.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -9.0F, -3.0F, -1.9788F, 0.0664F, 0.7745F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 10).addBox(-4.0F, -3.0F, -4.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -6.0F, -4.0F, -1.4585F, 0.2656F, 0.7949F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(42, 57).addBox(-4.0F, -3.0F, -4.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.0F, -4.0F, -1.8564F, 0.0365F, -1.0579F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 64).addBox(-4.0F, -3.0F, -5.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -11.0F, 0.0F, -2.435F, 0.4653F, -0.5867F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 57).addBox(-4.0F, -3.0F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.0F, -5.0F, -1.562F, 0.5988F, -0.6831F));

		PartDefinition arms = boreal_golem.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-23.0F, -20.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(42, 47).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 58).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 20).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(32.0F, -7.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -2.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 29).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 38).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
    public void setupAnim(BorealGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(BorealAnimationDefinitions.BOREAL_GOLEM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void prepareMobModel(BorealGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks) {
        super.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);

        int i = entity.getAttackAnimationTick();
        if (i > 0) {
            float anim = Mth.triangleWave((float)i - partialTicks, 10.0F);
            this.right_arm.xRot = -2.0F + 1.5F * anim;
            this.left_arm.xRot = -2.0F + 1.5F * anim;
        }
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		boreal_golem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return boreal_golem;
    }
}