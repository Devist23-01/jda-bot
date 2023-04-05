package org.kawai.handler;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.kawai.config.CommendConfig;
import org.kawai.config.Commendable;
import org.kawai.utils.BotEventUtils;

public class MessageReceiveHandler extends ListenerAdapter {

    CommendConfig commendConfig = new CommendConfig();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        char signature = message.charAt(0);
        String newMessage = message.substring(1);

        if (BotEventUtils.isBot(event)) {
            return;
        }


        if (signature == '%') {
            event.getChannel().sendMessage("안녕 선생" + newMessage).queue();
        }

        String[] splited = event.getMessage().getContentRaw().split(" ");
        Commendable commend = commendConfig.getCommend(splited[0]);

        commend.doCommend(event.getChannel(), BotEventUtils.ExtreactRawMessage(event));


    }
}
