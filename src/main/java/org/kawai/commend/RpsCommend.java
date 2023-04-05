package org.kawai.commend;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.kawai.config.Commendable;

public class RpsCommend implements Commendable {
    @Override
    public void doCommend(MessageChannel channel, String message) {
        // message : !도박 가위
        String s1 = message.substring(1);
        String[] splited = s1.split(" ");

        if (splited.length != 2) {
            return;
        }

        //  0 : 가위
        //  1 : 바위
        //  2 : 보
        int percentage = (int) (Math.random() * 3);
        int computer;

        if (percentage == 0) {
            computer = 0;
        } else if (percentage == 1) {
            computer = 1;
        } else {
            computer = 2;
        }

        if (splited[1].equals("가위")) {
            if (computer == 0) {
                channel.sendMessage("비겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("졌습니다!").queue();
            } else {
                channel.sendMessage("이겼습니다!").queue();
            }
        } else if (splited[1].equals("바위")) {
            if (computer == 0) {
                channel.sendMessage("이겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("비겼습니다!").queue();
            } else {
                channel.sendMessage("졌습니다!").queue();
            }
        } else if (splited[1].equals("보")) {
            if (computer == 0) {
                channel.sendMessage("졌습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("이겼습니다!").queue();
            } else {
                channel.sendMessage("비겼습니다!").queue();
            }
        }

    }

    @Override
    public String getCommendType() {
        return "가위바위보";
    }
}
