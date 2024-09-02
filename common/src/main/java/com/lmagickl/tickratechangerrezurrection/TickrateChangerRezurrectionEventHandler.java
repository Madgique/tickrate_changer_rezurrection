package com.lmagickl.tickratechangerrezurrection;

import com.lmagickl.tickratechangerrezurrection.command.TickrateChangerRezurrectionCommands;
import com.mojang.brigadier.CommandDispatcher;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public enum TickrateChangerRezurrectionEventHandler {
    INSTANCE;

    void init() {
        CommandRegistrationEvent.EVENT.register(this::registerCommands);
    }

    private void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                  Commands.CommandSelection selection) {
        TickrateChangerRezurrectionCommands.register(dispatcher);
    }
}
