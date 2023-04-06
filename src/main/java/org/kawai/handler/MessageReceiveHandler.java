package org.kawai.handler;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.kawai.commend.CommendHolder;
import org.kawai.commend.CommendType;
import org.kawai.utils.BotEventUtils;

import java.util.Arrays;

public class MessageReceiveHandler extends ListenerAdapter {
    private final CommendHolder holder = CommendHolder.getInstance();


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (BotEventUtils.isBot(event)) {
            return;
        }

        String message = event.getMessage().getContentRaw();


        if (!message.startsWith("!")) {
            CommendType reaction = CommendType.from(message);
            holder.getCommendableMap().get(reaction).doCommend(event.getChannel(), message);
            return;
        }

        String userMessage = message.substring(1);

        String[] splitedUserMessage = userMessage.split(" ");

        String commend = splitedUserMessage[0];
        CommendType commendType = CommendType.from(commend);


        String[] strings = Arrays.copyOfRange(splitedUserMessage, 1, splitedUserMessage.length);
        holder.getCommendableMap()
                .get(commendType).doCommend(event.getChannel(), String.join(" ", strings));
    }
}
