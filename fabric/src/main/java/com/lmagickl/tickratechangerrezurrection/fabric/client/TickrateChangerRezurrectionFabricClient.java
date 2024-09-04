package com.lmagickl.tickratechangerrezurrection.fabric.client;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrectionNetwork;
import net.fabricmc.api.ClientModInitializer;

public final class TickrateChangerRezurrectionFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TickrateChangerRezurrectionNetwork.registerPackets();
    }
}
