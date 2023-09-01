package com.lmsoftware.pleyacraft.client.renderer;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.PleyadianModel;
import com.lmsoftware.pleyacraft.client.models.UpperPleyadianModel;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.entities.UpperPleyadianEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class UpperPleyadianRenderer extends MobRenderer<UpperPleyadianEntity, UpperPleyadianModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Pleyacraft.MODID, "textures/entities/upper_pleyadian.png");

    public UpperPleyadianRenderer(EntityRendererProvider.Context context) {
        super(context, new UpperPleyadianModel(context.bakeLayer(UpperPleyadianModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(UpperPleyadianEntity p_115812_) {
        // TODO Auto-generated method stub
        return TEXTURE;
    }
}