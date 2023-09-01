package com.lmsoftware.pleyacraft.events;

import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.entities.RigelianEntity;
import com.lmsoftware.pleyacraft.init.InitItems;

@Mod.EventBusSubscriber(modid = Pleyacraft.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobLootHandler {

    // @SubscribeEvent
    // public static void onLivingDrops(LivingDropsEvent event) {
    //     if (event.getEntity() instanceof RigelianEntity) {
    //         // Random rand = (Random) event.getEntity().getRandom();
    //         // if (rand.nextFloat() < 0.5f) {
    //             // Agrega un ítem con una probabilidad del 50%
    //             event.getDrops().add(new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.DIAMOND)));
    //             event.getDrops().add(new ItemEntity(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.IRON_INGOT)));
    //         // }
    //     }
    // }
}
