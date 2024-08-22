package com.lmagickl.tickratechangerrezurrection;

public class TickrateMessage  {
    private float tickrate;

    public TickrateMessage () {
        // Message creation
    }

    public TickrateMessage(float tickrate) {
        this.tickrate = tickrate;
    }

    public float getTickrate() {
        return tickrate;
    }
   /* public void encode(FriendlyByteBuf buf) {
        buf.writeFloat(tickrate);
    }*/
}
