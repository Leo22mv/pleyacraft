package com.lmsoftware.pleyacraft.client.renderer;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.RigelianModel;
import com.lmsoftware.pleyacraft.client.models.RocketModel;
import com.lmsoftware.pleyacraft.entities.RocketEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

// public class RocketRenderer extends EntityRenderer<RocketEntity> implements RenderLayerParent<RocketEntity, RocketModel> {
public class RocketRenderer extends MobRenderer<RocketEntity, RocketModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Pleyacraft.MODID, "textures/entities/rocket.png");
    // protected RocketModel model;

    public RocketRenderer(Context p_174304_) {
        super(p_174304_, new RocketModel(p_174304_.bakeLayer(RocketModel.LAYER_LOCATION)), 0.25f);
    }

    // public RocketRenderer(EntityRendererProvider.Context context) {
    //     super(context);
    //     this.model = new RocketModel(context.bakeLayer(RocketModel.LAYER_LOCATION));
    // }

    @Override
    public ResourceLocation getTextureLocation(RocketEntity p_114482_) {
        return TEXTURE;
    }

    // @Override
    // public RocketModel getModel() {
    //     return this.model;
    // }
    
}
