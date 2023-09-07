package com.lmsoftware.pleyacraft.travel;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.event.level.NoteBlockEvent.Play;

public class PlayerTravel {
    boolean onRocket;
    String destination;
    List<String> avaliableDestinations = new ArrayList<>();

    public boolean isOnRocket() {
        return onRocket;
    }

    public void setOnRocket(boolean b) {
        this.onRocket = b;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public void addAvaliableDestination(String destination) {
        avaliableDestinations.add(destination);
    }

    public void setAvaliableDestinations(List<String> avaliableDestinations) {
        this.avaliableDestinations = avaliableDestinations;
    }

    public List<String> getAvaliableDestinations() {
        return this.avaliableDestinations;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putBoolean("onRocket", onRocket);
    }

    public void loadNBTData(CompoundTag nbt) {
        onRocket = nbt.getBoolean("onRocket");
    }
}
