package org.kawai.commend;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.kawai.Game;
import org.kawai.config.Commendable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageCommend implements Commendable {
    @Override
    public void doCommend(MessageChannel channel, String userMessage) {
        // 컨트롤 + 알트 + v
        URL resource = Game.class.getClassLoader().getResource("cocomi.png");
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        } catch (IOException e) {
            System.out.println("파일이 없네");
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            System.out.println("경로가 이상하네");
            throw new RuntimeException(e);
        }
        channel.sendFile(bytes, "cocomi.png").queue();
    }

    @Override
    public CommendType getCommendType() {
        return CommendType.IMAGE;
    }
}
