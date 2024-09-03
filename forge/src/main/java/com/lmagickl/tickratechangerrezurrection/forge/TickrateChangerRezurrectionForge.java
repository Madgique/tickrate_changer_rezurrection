package com.lmagickl.tickratechangerrezurrection.forge;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrection;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrectionNetwork;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TickrateChangerRezurrection.MOD_ID)
public final class TickrateChangerRezurrectionForge {
    public TickrateChangerRezurrectionForge() {
        // Submit our event bus to let Architectury API register our content on the
        // right time.
        EventBuses.registerModEventBus(TickrateChangerRezurrection.MOD_ID,
                FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        new TickrateChangerRezurrection().init();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> TickrateChangerRezurrectionNetwork::registerPackets);

    }


}
