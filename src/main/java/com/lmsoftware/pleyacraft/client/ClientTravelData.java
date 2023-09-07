package com.lmsoftware.pleyacraft.client;

import java.util.ArrayList;
import java.util.List;

public class ClientTravelData {
    private static boolean isOnRocket;
    private static int destination;
    
    public static void setIsOnRocket(boolean isOnRocket) {
        ClientTravelData.isOnRocket = isOnRocket;
    }

    public static boolean isOnRocket() {
        return isOnRocket;
    }

    public static void setDestination(int destination) {
        destination = destination;
    }

    public static int getDestination() {
        return destination;
    }
}
