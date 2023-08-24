package com.lmsoftware.pleyacraft.client.renderer;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.PleyadianModel;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class PleyadianRenderer extends MobRenderer<PleyadianEntity, PleyadianModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Pleyacraft.MODID, "textures/entities/pleyadian.png");

    public PleyadianRenderer(EntityRendererProvider.Context context) {
        super(context, new PleyadianModel(context.bakeLayer(PleyadianModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(PleyadianEntity p_115812_) {
        // TODO Auto-generated method stub
        return TEXTURE;
    }
}