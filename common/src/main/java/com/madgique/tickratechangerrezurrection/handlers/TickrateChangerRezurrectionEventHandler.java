package com.madgique.tickratechangerrezurrection.handlers;

import com.madgique.tickratechangerrezurrection.command.TickrateChangerRezurrectionCommands;
import com.mojang.brigadier.CommandDispatcher;

import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public enum TickrateChangerRezurrectionEventHandler {
  INSTANCE;

  public void init() {
    CommandRegistrationEvent.EVENT.register(this::registerCommands);

  }

  private void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                CommandBuildContext context,
                                Commands.CommandSelection selection) {
    TickrateChangerRezurrectionCommands.register(dispatcher);
  }
}
