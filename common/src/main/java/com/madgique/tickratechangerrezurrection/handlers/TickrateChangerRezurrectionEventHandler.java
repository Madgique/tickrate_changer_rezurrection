package com.madgique.tickratechangerrezurrection.handlers;

import com.madgique.tickratechangerrezurrection.command.TickrateChangerRezurrectionCommands;
import com.mojang.brigadier.CommandDispatcher;

import me.shedaniel.architectury.event.events.CommandRegistrationEvent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public enum TickrateChangerRezurrectionEventHandler {
    INSTANCE;

    public void init() {
        CommandRegistrationEvent.EVENT.register(this::registerCommands);

    }

    private void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                  Commands.CommandSelection selection) {
        TickrateChangerRezurrectionCommands.register(dispatcher);
    }
}
