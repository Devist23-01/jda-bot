package org.kawai;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceiveHandler extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        char signature = message.charAt(0);
        String newMessage = message.substring(1);


        if (event.getAuthor().isBot()) {
            return;
        }

        if (signature == '!') {
            event.getChannel().sendMessage("안녕 선생" + newMessage).queue();
        }
    }
}
