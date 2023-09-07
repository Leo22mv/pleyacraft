package com.lmsoftware.pleyacraft.client.renderer;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.client.models.RigelianModel;
import com.lmsoftware.pleyacraft.client.models.UpperPleyadianModel;
import com.lmsoftware.pleyacraft.client.models.UpperRigelianModel;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;
import com.lmsoftware.pleyacraft.entities.UpperPleyadianEntity;
import com.lmsoftware.pleyacraft.entities.UpperRigelianEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class UpperRigelianRenderer extends MobRenderer<UpperRigelianEntity, UpperRigelianModel>{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Pleyacraft.MODID, "textures/entities/upper_rigelian.png");

    public UpperRigelianRenderer(EntityRendererProvider.Context context) {
        super(context, new UpperRigelianModel(context.bakeLayer(UpperRigelianModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(UpperRigelianEntity p_115812_) {
        // TODO Auto-generated method stub
        return TEXTURE;
    }
}
