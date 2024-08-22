package com.lmagickl.tickratechangerrezurrection.forge;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrectionMod;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TickrateChangerRezurrectionMod.MOD_ID)
public final class TickrateChangerRezurrectionForge {
    public TickrateChangerRezurrectionForge() {
        // Submit our event bus to let Architectury API register our content on the
        // right time.
        EventBuses.registerModEventBus(TickrateChangerRezurrectionMod.MOD_ID,
                FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        TickrateChangerRezurrectionMod.init();

    }


}
