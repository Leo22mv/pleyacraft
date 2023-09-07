package com.lmsoftware.pleyacraft.client.models;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;
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

public class RigelianModel extends EntityModel<RigelianEntity> {
		public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Pleyacraft.MODID, "rigelian_model"), "main");
		private final ModelPart bb_main;

		public RigelianModel(ModelPart root) {
			this.bb_main = root.getChild("bb_main");
		}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

			PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(1.5625F, -33.75F, -8.375F, 1.25F, 1.25F, 1.25F, new CubeDeformation(0.0F))
			.texOffs(0, 2).addBox(-5.325F, -33.75F, -8.375F, 1.25F, 1.25F, 1.25F, new CubeDeformation(0.0F))
			.texOffs(26, 16).addBox(-5.0F, -32.5F, -8.125F, 0.625F, 5.0F, 0.625F, new CubeDeformation(0.0F))
			.texOffs(26, 16).addBox(1.875F, -32.5F, -8.125F, 0.625F, 5.0F, 0.625F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8798F, 0.0F, 3.1416F));

			PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 24).addBox(-7.5F, -13.75F, -5.0F, 2.5F, 1.25F, 10.625F, new CubeDeformation(0.0F))
			.texOffs(26, 5).addBox(2.5F, -13.75F, -5.0F, 2.5F, 1.25F, 10.625F, new CubeDeformation(0.0F))
			.texOffs(32, 16).addBox(-7.5F, -7.5F, -2.5F, 2.5F, 7.5F, 5.0F, new CubeDeformation(0.0F))
			.texOffs(0, 35).addBox(2.5F, -7.5F, -2.5F, 2.5F, 7.5F, 5.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(-7.5F, -30.0F, -2.5F, 12.5F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

			PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 36).addBox(-3.0F, -20.0F, -12.5F, 3.25F, 8.75F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6616F, 0.0F, -3.1416F));

			PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 15).addBox(-5.0F, -20.0F, -2.5F, 7.5F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.8798F, 0.0F, 3.1416F));

			return LayerDefinition.create(meshdefinition, 64, 64);
		}

		@Override
		public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
			bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		@Override
		public void setupAnim(RigelianEntity p_102618_, float p_102619_, float p_102620_, float p_102621_,
				float p_102622_, float p_102623_) {
			// TODO Auto-generated method stub
			
		}
}