package com.madgique.tickratechangerrezurrection.command;

import com.madgique.tickratechangerrezurrection.TickrateChangerRezurrection;
import com.madgique.tickratechangerrezurrection.api.TickrateAPI;
import com.madgique.tickratechangerrezurrection.config.ClothConfigGUIBuilder;
import com.madgique.tickratechangerrezurrection.config.TickrateChangerRezurrectionConfig;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.MinecraftServer;

import static net.minecraft.ChatFormatting.*;

public class TickrateChangerRezurrectionCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("tickrate")
                .requires(s -> s.getServer() != null && s.getServer().isSingleplayer() || hasChangeTickratePermission(s))
                .then(Commands.literal("help")
                        .executes(context -> showHelp(context.getSource()))
                )
                .then(Commands.argument("ticks", IntegerArgumentType.integer())
                        .executes(c -> changeTickrate(c))
                )
                .executes(context -> {
                    return showInfo(context.getSource());
//                    context.getSource().sendFailure(new TextComponentString("Usage: /tickrate [ticks per second] [all/server/client/playername]"));
                })
        );
    }

    private static boolean hasChangeTickratePermission(CommandSourceStack stack) {
        return stack.hasPermission(2);
    }

    private static int changeTickrate(CommandContext<CommandSourceStack> context) {
        int tickrate = IntegerArgumentType.getInteger(context, "ticks");
        MinecraftServer server = context.getSource().getServer();
        TickrateAPI.changeTickrate(tickrate, server);
        return Command.SINGLE_SUCCESS;
    }

    private static int showHelp(CommandSourceStack source) {
        source.sendSuccess(new TextComponent("Usage: /tickrate [ticks per second] [help/info]"), false);
        source.sendSuccess(new TextComponent("/tickrate help - Shows this help message"), false);
        source.sendSuccess(new TextComponent("/tickrate info - Displays the current tickrate"), false);
        return 1;
    }

    private static int showInfo(CommandSourceStack source) {
        float currentClientTickrate = TickrateAPI.getClientTickrate();
        float currentServerTickrate = TickrateAPI.getServerTickrate();
        float defaultTickrate = TickrateChangerRezurrection.CONFIG.defaultTickrate;
        String SPACE = " ";

        Style currentMessagesStyle = Style.EMPTY.withColor(GREEN);
        Style defautMessagesStyle = Style.EMPTY.withColor(YELLOW);
        Style exampleMessagesStyle = Style.EMPTY.withColor(AQUA);
        Style helpMessagesStyle = Style.EMPTY.withColor(RED);

        TextComponent currentClientTickrateMessage = new TextComponent("Current Client Tickrate:" + SPACE);
        TextComponent currentServerTickrateMessage = new TextComponent("Current Server Tickrate:" + SPACE);
        TextComponent defaultTickrateMessage = new TextComponent("Default Tickrate:" + SPACE);

        TextComponent example1Message = new TextComponent("/tickrate <ticks per second> [all/server/client/ playername ]");
        TextComponent example2Message = new TextComponent("/tickrate setdefault <ticks per second> [--dontsave, --dontupdate]");
        TextComponent example3Message = new TextComponent("/tickrate setmap <ticks per second> [--dontupdate]");


        MutableComponent help1 = new TextComponent("Use" + SPACE).setStyle(helpMessagesStyle);
        MutableComponent help2 = new TextComponent("/tickrate help" + SPACE).setStyle(Style.EMPTY);
        MutableComponent help3 = new TextComponent("for more command info").setStyle(helpMessagesStyle);
        MutableComponent helpInfoMessage = help1.append(help2).append(help3);

        MutableComponent currentClientTickrateValueMessage = new TextComponent(currentClientTickrate + SPACE + "ticks per second").setStyle(currentMessagesStyle);
        MutableComponent currentServerTickrateValueMessage = new TextComponent(currentServerTickrate + SPACE + "ticks per second").setStyle(currentMessagesStyle);
        MutableComponent defaultTickrateValueMessage = new TextComponent(defaultTickrate + SPACE + "ticks per second").setStyle(defautMessagesStyle);

        source.sendSuccess(currentClientTickrateMessage.append(currentClientTickrateValueMessage), false);
        source.sendSuccess(currentServerTickrateMessage.append(currentServerTickrateValueMessage), false);
        source.sendSuccess(defaultTickrateMessage.append(defaultTickrateValueMessage), false);
        source.sendSuccess(new TextComponent(SPACE), false);
        source.sendSuccess(example1Message.setStyle(exampleMessagesStyle), false);
        source.sendSuccess(example2Message.setStyle(exampleMessagesStyle), false);
        source.sendSuccess(example3Message.setStyle(exampleMessagesStyle), false);
        source.sendSuccess(new TextComponent(SPACE), false);
        source.sendSuccess(helpInfoMessage, false);

        return 1;
    }
}
