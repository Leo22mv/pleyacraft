package com.lmsoftware.pleyacraft;

import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.init.InitMobs;

import static com.lmsoftware.pleyacraft.init.InitMobs.MOBS;
import com.lmsoftware.pleyacraft.init.PlaceFeature;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.world.dimension.ModDimensions;
import com.lmsoftware.pleyacraft.events.MobsAttrsEvent;
import com.lmsoftware.pleyacraft.events.MobsRendererEvents;
import com.lmsoftware.pleyacraft.init.InitBlocks;
import com.lmsoftware.pleyacraft.init.InitFeatures;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(Pleyacraft.MODID)
public class Pleyacraft {
    public static final String MODID = "pleyacraft";

    public Pleyacraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        InitItems.ITEMS.register(bus);
        InitBlocks.BLOCKS.register(bus);
        EVENT_BUS.register(new MobsAttrsEvent());
        EVENT_BUS.register(new MobsRendererEvents());
        InitFeatures.CONFIGURED_FEATURES.register(bus);
        PlaceFeature.PLACED_FEATURE.register(bus);
        MOBS.register(bus);
        bus.addListener(this::commonSetup);
        ModDimensions.register();
    }   

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return InitItems.PLEYARITE_INGOT.get().getDefaultInstance();
        }
    };

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();

            SpawnPlacements.register(InitMobs.PLEYADIAN.get(),
            SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
        });
    }
}