package com.lmsoftware.pleyacraft.events;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.PleyadianEntity;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;
import com.lmsoftware.pleyacraft.entities.UpperPleyadianEntity;
import com.lmsoftware.pleyacraft.init.InitMobs;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pleyacraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobsAttrsEvent {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(InitMobs.PLEYADIAN.get(), PleyadianEntity.getPleyadianEntityAttrs().build());
        event.put(InitMobs.RIGELIAN.get(), RigelianEntity.getRigelianEntityAttrs().build());
        event.put(InitMobs.UPPER_PLEYADIAN.get(), UpperPleyadianEntity.getUpperPleyadianEntityAttrs().build());
    }
}
