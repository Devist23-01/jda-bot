package org.kawai;

import org.kawai.config.CommandConfig;
import org.kawai.config.JdaConfig;

public class Game {
    public static void main(String[] args) {
        String botKey = System.getProperty("bot_key", "");
        JdaConfig.startBot(botKey);
        new CommandConfig();
    }
}