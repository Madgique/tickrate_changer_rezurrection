package com.madgique.tickratechangerrezurrection.fabric.client;

import com.madgique.tickratechangerrezurrection.network.TickrateChangerRezurrectionNetwork;
import net.fabricmc.api.ClientModInitializer;

public final class TickrateChangerRezurrectionFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TickrateChangerRezurrectionNetwork.registerPackets();
    }
}
