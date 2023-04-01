package org.kawai;

public class Game {
    public static void main(String[] args) {
        String botKey = System.getProperty("bot_key", "");
        JdaConfig.startBot(botKey);
    }


}