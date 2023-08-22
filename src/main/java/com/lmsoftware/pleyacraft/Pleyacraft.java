package com.lmsoftware.pleyacraft;

import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.init.PlaceFeature;
import com.lmsoftware.pleyacraft.init.InitBlocks;
import com.lmsoftware.pleyacraft.init.InitFeatures;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
// import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(Pleyacraft.MODID)
public class Pleyacraft {
    public static final String MODID = "pleyacraft";

    public Pleyacraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        InitItems.ITEMS.register(bus);
        InitBlocks.BLOCKS.register(bus);
        // EVENT_BUS.register(new Events());
        InitFeatures.CONFIGURED_FEATURES.register(bus);
        PlaceFeature.PLACED_FEATURE.register(bus);
    }   
}