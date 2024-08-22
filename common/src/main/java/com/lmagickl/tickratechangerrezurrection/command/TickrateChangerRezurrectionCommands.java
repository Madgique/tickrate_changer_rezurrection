package com.lmagickl.tickratechangerrezurrection.command;

import com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrectionMod;
import com.lmagickl.tickratechangerrezurrection.api.TickrateAPI;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;

public class TickrateChangerRezurrectionCommands {
  public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
    dispatcher.register(Commands.literal("tickrate")
        .requires(s -> s.getServer() != null && s.getServer().isSingleplayer() || hasChangeTickratePermission(s))
        .then(Commands.argument("ticks", IntegerArgumentType.integer())
            .executes(c -> changeTickrate(c))
        )
        .executes(context -> {
          context.getSource().sendFailure(Component.literal("Usage: /tickrate [ticks per second] [all/server/client/playername]"));
          return 0;
        })
    );
  }

  private static boolean hasChangeTickratePermission(CommandSourceStack stack) {
    return stack.hasPermission(2);
  }

  private static int changeTickrate(CommandContext<CommandSourceStack> context) {
    int tickrate = IntegerArgumentType.getInteger(context, "ticks");
    MinecraftServer server = context.getSource().getServer();
    TickrateChangerRezurrectionMod.LOGGER.info("test" + tickrate);
    TickrateAPI.changeTickrate(tickrate, server);
    return Command.SINGLE_SUCCESS;
  }

  // private static void chat(ICommandSender sender, ITextComponent... comps) {
  //   ITextComponent top;
  //   if (comps.length == 1) {
  //     top = comps[0];
  //   } else {
  //     top = new TextComponentString("");
  //     for (ITextComponent c : comps) {
  //       top.appendSibling(c);
  //       top.appendText(" ");
  //     }
  //   }
  //   sender.sendMessage(top);
  // }

}
