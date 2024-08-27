package com.lmagickl.tickratechangerrezurrection;

import me.shedaniel.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

public class TickrateMessage  {
    private float tickrate;

    public TickrateMessage(FriendlyByteBuf buf) {
        this.tickrate = buf.readFloat();
    }

    public TickrateMessage(float tickrate) {
        this.tickrate = tickrate;
    }

    public float getTickrate() {
        return tickrate;
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeFloat(tickrate);
    }

    public static TickrateMessage decode(FriendlyByteBuf buf) {
        float tickrate = buf.readFloat();

        return new TickrateMessage(tickrate);
    }
}
