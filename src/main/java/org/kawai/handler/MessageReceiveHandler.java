package org.kawai.handler;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.kawai.command.CommandHolder;
import org.kawai.command.CommandType;
import org.kawai.utils.BotEventUtils;

import java.util.Arrays;

public class MessageReceiveHandler extends ListenerAdapter {
    private final CommandHolder holder = CommandHolder.getInstance();


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (BotEventUtils.isBot(event)) {
            return;
        }

        String message = event.getMessage().getContentRaw();


        if (!message.startsWith("!")) {
            CommandType reaction = CommandType.from(message);
            holder.getCommandableMap().get(reaction).doCommand(event.getChannel(), message);
            return;
        }

        String userMessage = message.substring(1);

        String[] splitedUserMessage = userMessage.split(" ");

        String Command = splitedUserMessage[0];
        CommandType CommandType = CommandType.from(Command);


        String[] strings = Arrays.copyOfRange(splitedUserMessage, 1, splitedUserMessage.length);
        holder.getCommandableMap()
                .get(CommandType).doCommand(event.getChannel(), String.join(" ", strings));
    }
}
