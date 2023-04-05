package org.kawai.config;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.kawai.handler.MessageReceiveHandler;

import javax.security.auth.login.LoginException;

public class JdaConfig {
    public static void startBot(String botKey) {

        JDABuilder builder = JDABuilder.createDefault(botKey);
        builder.addEventListeners(new MessageReceiveHandler());
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES);
        builder.setActivity(Activity.watching("MIKA"));

        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
