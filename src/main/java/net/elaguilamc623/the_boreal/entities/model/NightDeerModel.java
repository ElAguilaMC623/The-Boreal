package net.elaguilamc623.the_boreal.entities.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.elaguilamc623.the_boreal.entities.animations.BorealAnimationDefinitions;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class NightDeerModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart night_deer;
	private final ModelPart body;
	private final ModelPart trunk;
	private final ModelPart legs;
	private final ModelPart right_legs;
	private final ModelPart back;
	private final ModelPart back_up;
	private final ModelPart back_down;
	private final ModelPart front;
	private final ModelPart front_up;
	private final ModelPart front_down;
	private final ModelPart left_legs;
	private final ModelPart back_left;
	private final ModelPart front_left;
	private final ModelPart head;

	public NightDeerModel(ModelPart root) {
		this.night_deer = root.getChild("night_deer");
		this.body = this.night_deer.getChild("body");
		this.trunk = this.body.getChild("trunk");
		this.legs = this.body.getChild("legs");
		this.right_legs = this.legs.getChild("right_legs");
		this.back = this.right_legs.getChild("back");
		this.back_up = this.back.getChild("back_up");
		this.back_down = this.back.getChild("back_down");
		this.front = this.right_legs.getChild("front");
		this.front_up = this.front.getChild("front_up");
		this.front_down = this.front.getChild("front_down");
		this.left_legs = this.legs.getChild("left_legs");
		this.back_left = this.left_legs.getChild("back_left");
		this.front_left = this.left_legs.getChild("front_left");
		this.head = this.night_deer.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition night_deer = partdefinition.addOrReplaceChild("night_deer", CubeListBuilder.create(), PartPose.offset(-3.0F, 24.0F, 7.0F));

		PartDefinition body = night_deer.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition trunk = body.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -22.0F, -2.0F, 11.0F, 10.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(-5.0F, -19.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, -14.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_legs = legs.addOrReplaceChild("right_legs", CubeListBuilder.create(), PartPose.offset(8.0F, -10.0F, 0.0F));

		PartDefinition back = right_legs.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, -12.0F));

		PartDefinition back_up = back.addOrReplaceChild("back_up", CubeListBuilder.create().texOffs(26, 29).addBox(-1.0F, -13.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -2.0F));

		PartDefinition back_down = back.addOrReplaceChild("back_down", CubeListBuilder.create().texOffs(26, 29).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -2.0F));

		PartDefinition front = right_legs.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, 1.0F));

		PartDefinition front_up = front.addOrReplaceChild("front_up", CubeListBuilder.create().texOffs(36, 29).addBox(-1.0F, -13.0F, 12.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -15.0F));

		PartDefinition front_down = front.addOrReplaceChild("front_down", CubeListBuilder.create().texOffs(36, 29).addBox(-1.0F, -7.0F, 12.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -15.0F));

		PartDefinition left_legs = legs.addOrReplaceChild("left_legs", CubeListBuilder.create(), PartPose.offset(7.0F, 0.0F, -14.0F));

		PartDefinition back_left = left_legs.addOrReplaceChild("back_left", CubeListBuilder.create().texOffs(26, 45).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 45).addBox(-1.0F, 3.0F, -3.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -10.0F, 2.0F));

		PartDefinition front_left = left_legs.addOrReplaceChild("front_left", CubeListBuilder.create().texOffs(36, 45).addBox(-8.0F, -3.0F, -4.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 45).addBox(-8.0F, 3.0F, -4.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 16.0F));

		PartDefinition head = night_deer.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 29).addBox(1.0F, -29.0F, 6.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(0.0F, -32.0F, 0.0F, 7.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_horn_r1 = head.addOrReplaceChild("left_horn_r1", CubeListBuilder.create().texOffs(46, 44).addBox(-1.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -32.0F, 3.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition right_horn_r1 = head.addOrReplaceChild("right_horn_r1", CubeListBuilder.create().texOffs(46, 36).addBox(-1.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -32.0F, 2.0F, 0.0F, 0.6981F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
        this.animateWalk(BorealAnimationDefinitions.NIGHT_DEER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = -pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = -pHeadPitch * ((float)Math.PI / 180F);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		night_deer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return night_deer;
    }
}