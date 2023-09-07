package com.lmsoftware.pleyacraft.travel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerTravelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerTravel> PLAYER_TRAVEL = CapabilityManager.get(new CapabilityToken<PlayerTravel>() {  });

    private PlayerTravel travel = null;
    private final LazyOptional<PlayerTravel> optional = LazyOptional.of(this::createPlayerTravel);

    private PlayerTravel createPlayerTravel() {
        if (this.travel == null) {
            this.travel = new PlayerTravel();
        }

        return this.travel;
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_TRAVEL) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerTravel().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerTravel().loadNBTData(nbt);
    }
}
