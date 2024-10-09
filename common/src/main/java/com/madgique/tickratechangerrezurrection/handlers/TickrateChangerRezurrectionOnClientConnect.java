package com.madgique.tickratechangerrezurrection.handlers;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import com.madgique.tickratechangerrezurrection.api.TickrateAPI;
import me.shedaniel.architectury.event.events.CommandRegistrationEvent;
import me.shedaniel.architectury.event.events.PlayerEvent;

public enum TickrateChangerRezurrectionOnClientConnect {
    INSTANCE;

    public void init() {
        PlayerEvent.PLAYER_JOIN.register(player -> {
            TickrateAPI.changeClientTickrate(player, TickrateChangerRezurrection.CONFIG.defaultTickrate);
        });

    }
}
