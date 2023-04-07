package org.kawai.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.kawai.Game;
import org.kawai.config.Commandable;

import java.io.IOException;
import java.io.InputStream;

public class ImageCommand implements Commandable {
    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        // 컨트롤 + 알트 + v
        InputStream resourceAsStream = Game.class.getClassLoader().getResourceAsStream("cocomi.png");
        byte[] bytes = new byte[0];
        try {
            bytes = resourceAsStream.readAllBytes();
        } catch (IOException e) {
            System.out.println("파일이 없네");
            throw new RuntimeException(e);
        }
        channel.sendFile(bytes, "cocomi.png").queue();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.IMAGE;
    }
}
