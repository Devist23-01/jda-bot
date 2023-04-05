package org.kawai.commend;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.kawai.config.Commendable;

import static org.kawai.utils.BotEventUtils.sendMessage;

public class ReactionCommend implements Commendable {

    @Override
    public void doCommend(MessageChannel channel, String userMessage) {
        if (userMessage.equals("센세")) {
            sendMessage(channel, "ToraMochi 의 그림을 보려면 n월을 입력해줘 !!");
        }

        if (userMessage.equals("4월")) {
            sendMessage(channel, "4월은 고통입니다.");
        }
    }

    @Override
    public String getCommendType() {
        return "반응";
    }

}
