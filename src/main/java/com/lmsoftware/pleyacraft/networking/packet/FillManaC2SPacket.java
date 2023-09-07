package com.lmsoftware.pleyacraft.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import com.lmsoftware.pleyacraft.mana.PlayerManaProvider;
import com.lmsoftware.pleyacraft.networking.ModMessages;

public class FillManaC2SPacket {

    public FillManaC2SPacket() {

    }

    public FillManaC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
                mana.addMana(1);
                // player.sendSystemMessage(Component.literal("Current Mana " + mana.getMana())
                //         .withStyle(ChatFormatting.AQUA)
                //         );
                ModMessages.sendToPlayer(new ManaDataSyncS2CPacket(mana.getMana()), player);
            });
        });
        return true;
    }
}