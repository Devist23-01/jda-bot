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


        // 접두 없는 일반 명령어는 만들지 않는게 좋으니 , 일반채팅으로써 읽히게함
        if (!message.startsWith("!")) {
            CommandType reaction = CommandType.from(message);
            holder.getCommandableMap().get(reaction).doCommand(event.getChannel(), event.getAuthor(), message);
            return;
        }

        // 접두가 있어야 실행됨

        String userMessage = message.substring(1);

        String[] splitedUserMessage = userMessage.split(" ");

        String command = splitedUserMessage[0];
        CommandType commandType = CommandType.from(command);


        String[] strings = Arrays.copyOfRange(splitedUserMessage, 1, splitedUserMessage.length);
        holder.getCommandableMap()
                .get(commandType).doCommand(event.getChannel(), event.getAuthor(), String.join(" ", strings));
    }
}
