package com.madgique.tickratechangerrezurrection.fabric;

import com.madgique.tickratechangerrezurrection.config.TickrateChangerRezurrectionConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;

public final class TickrateChangerRezurrectionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        AutoConfig.register(TickrateChangerRezurrectionConfig.class, GsonConfigSerializer::new);

        new TickrateChangerRezurrection().init();
    }
}
