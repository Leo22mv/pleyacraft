package com.lmsoftware.pleyacraft.client;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ClientDestinationData {
    private static int destination;

    public static void setDestination(int destination) {
        ClientDestinationData.destination = destination;
    }

    public static int getDestination() {
        return destination;
    }
}
