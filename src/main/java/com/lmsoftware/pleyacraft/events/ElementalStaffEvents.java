package com.lmsoftware.pleyacraft.events;

import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;

import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;



public class ElementalStaffEvents {
    @SubscribeEvent
    public void spell(RightClickItem event) {
        var item = event.getItemStack();
        if (event.getSide().isServer()) {
            var server = event.getEntity().getServer();
            if(item.is(InitItems.ELEMENTAL_STAFF.get()) && server != null) {
                var stack = server.createCommandSourceStack();
                var player = event.getEntity();
                var pos = player.position();
                var command = "fill " + (int)(pos.x - 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 2) + " " + (int)(pos.x + 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z + 2) + " minecraft:ice";
                server.getCommands().performCommand(
                        stack,
                        command
                );

                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                if(mana.getMana() > 0) {
                    mana.subMana(1);
                    player.sendSystemMessage(Component.literal("Subtracted mana"));
                }
                });

                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void spell(RightClickBlock event) {
        var item = event.getItemStack();
        if (event.getSide().isServer()) {
            var server = event.getEntity().getServer();
            if(item.is(InitItems.ELEMENTAL_STAFF.get()) && server != null) {
                var stack = server.createCommandSourceStack();
                var player = event.getEntity();
                var pos = player.position();
                var command = "fill " + (int)(pos.x - 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z - 2) + " " + (int)(pos.x + 2) + " " + (int)(pos.y - 1) + " " + (int)(pos.z + 2) + " minecraft:ice";
                server.getCommands().performCommand(
                        stack,
                        command
                );

                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                if(mana.getMana() > 0) {
                    mana.subMana(1);
                    player.sendSystemMessage(Component.literal("Subtracted mana"));
                }
                });

                event.setCanceled(true);
            }
        }
    }
}