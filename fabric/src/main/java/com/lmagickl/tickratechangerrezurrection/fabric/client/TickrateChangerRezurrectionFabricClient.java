package com.lmagickl.tickratechangerrezurrection.fabric.client;

import com.lmagickl.tickratechangerrezurrection.TickrateChangeRezurrectionNetwork;
import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrection;
import com.lmagickl.tickratechangerrezurrection.TickrateMessage;
import me.shedaniel.architectury.networking.NetworkManager;
import net.fabricmc.api.ClientModInitializer;

public final class TickrateChangerRezurrectionFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TickrateChangeRezurrectionNetwork.registerPackets();
    }
}
