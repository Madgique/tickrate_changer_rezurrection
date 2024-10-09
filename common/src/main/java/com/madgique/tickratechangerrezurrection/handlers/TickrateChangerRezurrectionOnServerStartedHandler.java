package com.madgique.tickratechangerrezurrection.handlers;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;

import me.shedaniel.architectury.event.events.LifecycleEvent;


public enum TickrateChangerRezurrectionOnServerStartedHandler {
    INSTANCE;

    public void init() {
        LifecycleEvent.SERVER_STARTED.register(server -> {
            // Applique le tickrate par défaut de la configuration
            TickrateChangerRezurrection.applyDefaultTickrate(server);
        });

    }
}
