package org.kawai.config;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.kawai.command.CommandType;

public interface Commandable {
    //    행위의 틀
    void doCommand(MessageChannel channel, User user, String userMessage);

    CommandType getCommandType();
}
