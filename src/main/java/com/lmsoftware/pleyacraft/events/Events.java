package com.lmsoftware.pleyacraft.events;

import java.util.ArrayList;

import com.lmsoftware.pleyacraft.Pleyacraft;
import com.lmsoftware.pleyacraft.init.InitItems;
import com.lmsoftware.pleyacraft.mana.PlayerMana;
import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;
import com.lmsoftware.pleyacraft.networking.ModMessages;
import com.lmsoftware.pleyacraft.networking.packet.FillManaC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.HideTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.ManaDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.networking.packet.ShowTravelHudC2SPacket;
import com.lmsoftware.pleyacraft.networking.packet.TravelDataSyncS2CPacket;
import com.lmsoftware.pleyacraft.travel.PlayerTravel;
import com.lmsoftware.pleyacraft.travel.PlayerTravelProvider;
import com.lmsoftware.pleyacraft.world.dimension.ModDimensions;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Pleyacraft.MODID)
public class Events {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) {
                event.addCapability(new ResourceLocation(Pleyacraft.MODID, "mana_properties"), new PlayerManaProvider());
            }

            if(!event.getObject().getCapability(PlayerTravelProvider.PLAYER_TRAVEL).isPresent()) {
                event.addCapability(new ResourceLocation(Pleyacraft.MODID, "travel_properties"), new PlayerTravelProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerMana.class);
        event.register(PlayerTravel.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            if (!event.player.isCreative()) {
                if(event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    ModMessages.sendToServer(new FillManaC2SPacket());
                }
            } else {
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    if (mana.getMana() == 0) {
                        ModMessages.sendToServer(new FillManaC2SPacket());
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                    mana.addMana(10);
                    ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
                });
                player.getCapability(PlayerTravelProvider.PLAYER_TRAVEL).ifPresent(travel -> {
                    travel.setAvaliableDestinations(new ArrayList<>());

                    travel.addAvaliableDestination("earth");
                    travel.addAvaliableDestination("atlas");
                    travel.addAvaliableDestination("rigel");

                    var avaliableDestinations = travel.getAvaliableDestinations();
                    int destinationId = 0;

                    if (player.level.dimension() == Level.OVERWORLD) {
                        avaliableDestinations.remove("earth");
                        String destination = avaliableDestinations.get(0);
                        travel.setDestination(destination);
                    } else if (player.level.dimension() == ModDimensions.ATLASDIM_KEY) {
                        avaliableDestinations.remove("atlas");
                        String destination = avaliableDestinations.get(0);
                        travel.setDestination(destination);
                    } else {
                        avaliableDestinations.remove("rigel");
                        String destination = avaliableDestinations.get(0);
                        travel.setDestination(destination);
                    }

                    switch (travel.getDestination()) {
                        case "earth":
                            destinationId = 1;
                            break;

                        case "atlas":
                            destinationId = 2;
                            break;

                        case "rigel":
                            destinationId = 3;
                            break;
                    
                        default:
                            break;
                    }

                    travel.setOnRocket(false);
                    player.stopRiding();

                    // player.sendSystemMessage(Component.literal(destinationId + " y ella"));
                    // player.sendSystemMessage(Component.literal(travel.getDestination()));

                    ModMessages.sendToPlayer(new TravelDataSyncS2CPacket(travel.isOnRocket(), destinationId), player);
                });
            }
        }
    }
}
