package com.lmagickl.tickratechangerrezurrection;

import dev.architectury.networking.NetworkChannel;
import dev.architectury.networking.NetworkManager;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.client.Minecraft;

public final class TickrateChangerRezurrectionMod {
    public static TickrateChangerRezurrectionMod INSTANCE;
    public static final String MOD_ID = "tickratechangerrezurrection";

    public static Logger LOGGER = LogManager.getLogger("Tickrate Changer");
    public static TickrateChangerRezurrectionConfig CONFIG = new TickrateChangerRezurrectionConfig();

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

    public static void init() {
        TickrateChangerRezurrectionEventHandler.INSTANCE.init();
    }

    public static boolean isClient() {
        return Platform.getEnvironment() == Env.CLIENT;
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

//       mc.timer.tickLength = 1000F / tickrate;
    }

    public void updateServerTickrate(float tickrate, boolean log) {
        if (log)
            LOGGER.info("Updating server tickrate to " + tickrate);

        MILISECONDS_PER_TICK = (long) (1000L / tickrate);
    }
}
