package com.lmagickl.tickratechangerrezurrection;

import com.lmagickl.tickratechangerrezurrection.mixin.MinecraftAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;


public final class TickrateChangerRezurrection {
    public static final String MOD_ID = "tickrate_changer_rezurrection";

    public static TickrateChangerRezurrection INSTANCE;

    public static Logger LOGGER = LogManager.getLogger("Tickrate Changer");
    public static TickrateChangerRezurrectionConfig CONFIG = new TickrateChangerRezurrectionConfig();
    public static final ResourceLocation TICKRATE = new ResourceLocation(MOD_ID, "tickrate");

    // Gamerule
    public static final String GAME_RULE = "tickrate";

    // Default tickrate - can be changed in the config file
    public static float DEFAULT_TICKRATE = 20;
    // Stored client-side tickrate
    public static float TICKS_PER_SECOND = 20;
    // Server-side tickrate in miliseconds
    public static long MILISECONDS_PER_TICK = 50L;
    // Sound speed
    public static float GAME_SPEED = 1;
    // Min Tickrate
    public static float MIN_TICKRATE = 0.1F;
    // Max Tickrate
    public static float MAX_TICKRATE = 1000;
    // Show Messages
    public static boolean SHOW_MESSAGES = true;
    // Change sound speed
    public static boolean CHANGE_SOUND = true;

    public TickrateChangerRezurrection() {
        INSTANCE = this;
    }

    public void init() {
        TickrateChangerRezurrectionEventHandler.INSTANCE.init();
    }

    @Environment(EnvType.CLIENT)
    public void updateClientTickrate(float tickrate, boolean log) {
        if (log)
            LOGGER.info("Updating client tickrate to " + tickrate);

        TICKS_PER_SECOND = tickrate;
        if (CHANGE_SOUND)
            GAME_SPEED = tickrate / 20F;

        Minecraft mc = Minecraft.getInstance();
        if (mc == null)
            return; // Wut

        Timer timer = ((MinecraftAccessor) mc).getTimer();

        // change tickrate client-side
        ((TickrateChanger) (Object) timer).changeClientTickrate(tickrate, System.currentTimeMillis());
    }

    public void updateServerTickrate(float tickrate, boolean log) {
        if (log)
            LOGGER.info("Updating server tickrate to " + tickrate);

        // change tickrate server-side
        MILISECONDS_PER_TICK = (long) (1000L / tickrate);
    }
}