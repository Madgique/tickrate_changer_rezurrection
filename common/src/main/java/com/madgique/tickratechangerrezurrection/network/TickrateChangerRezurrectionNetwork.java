package com.madgique.tickratechangerrezurrection.network;


import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import me.shedaniel.architectury.networking.NetworkManager;

public class TickrateChangerRezurrectionNetwork {

    public static void registerPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, TickrateChangerRezurrection.TICKRATE, ((buf, context) -> {
            float tickrate = buf.readFloat();
            TickrateChangerRezurrection.LOGGER.info("Tickrate received from Server: " + tickrate);

            if (tickrate < TickrateChangerRezurrection.CONFIG.minTickrate) {
                TickrateChangerRezurrection.LOGGER.info("Tickrate forced to change from " + tickrate + " to " +
                        TickrateChangerRezurrection.CONFIG.minTickrate + ", because the value is too low" +
                        " (You can change the minimum tickrate in the config)");
                tickrate = TickrateChangerRezurrection.CONFIG.minTickrate;
            } else if (tickrate > TickrateChangerRezurrection.CONFIG.maxTickrate) {
                TickrateChangerRezurrection.LOGGER.info("Tickrate forced to change from " + tickrate + " to " +
                        TickrateChangerRezurrection.CONFIG.maxTickrate + ", because the value is too high" +
                        " (You can change the maximum tickrate in the config)");
                tickrate = TickrateChangerRezurrection.CONFIG.maxTickrate;
            }
            TickrateChangerRezurrection.INSTANCE.updateClientTickrate(tickrate, TickrateChangerRezurrection.CONFIG.showMessages);
        }));

    }
}
