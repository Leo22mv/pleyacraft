package com.lmsoftware.pleyacraft.client.models;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.entities.UpperPleyadianEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class UpperPleyadianModel extends EntityModel<UpperPleyadianEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Pleyacraft.MODID, "upper_pleyadian"), "main");
	private final ModelPart bb_main;

	public UpperPleyadianModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 17).addBox(3.0F, -21.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 16).addBox(3.0F, -16.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(18, 30).addBox(-1.0F, -22.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-4.0F, -21.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 16).addBox(-4.0F, -16.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(35, 11).addBox(-3.0F, -35.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 45).addBox(-6.0F, -15.0F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(8, 34).addBox(-3.0F, -21.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(UpperPleyadianEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}