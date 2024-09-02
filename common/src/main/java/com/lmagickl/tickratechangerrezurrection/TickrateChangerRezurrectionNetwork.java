package com.lmagickl.tickratechangerrezurrection;


import dev.architectury.networking.NetworkManager;

import static com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrection.LOGGER;

public class TickrateChangerRezurrectionNetwork {

    public static void registerPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, TickrateChangerRezurrection.TICKRATE, ((buf, context) -> {
            float tickrate = buf.readFloat();
            LOGGER.info("Packet on client received: " + tickrate);
            TickrateChangerRezurrection.INSTANCE.updateClientTickrate(tickrate, TickrateChangerRezurrection.SHOW_MESSAGES);
        }));

    }
}
