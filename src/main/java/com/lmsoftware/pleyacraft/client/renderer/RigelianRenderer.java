package com.lmsoftware.pleyacraft.client.renderer;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.PleyadianModel;
import com.lmsoftware.pleyacraft.client.models.RigelianModel;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RigelianRenderer extends MobRenderer<RigelianEntity, RigelianModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Pleyacraft.MODID, "textures/entities/rigelian.png");

    public RigelianRenderer(EntityRendererProvider.Context context) {
        super(context, new RigelianModel(context.bakeLayer(RigelianModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(RigelianEntity p_115812_) {
        // TODO Auto-generated method stub
        return TEXTURE;
    }
}
