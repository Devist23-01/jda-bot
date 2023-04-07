package org.kawai.config;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.kawai.command.CommandType;

public interface Commandable {
    //    행위의 틀
    void doCommand(MessageChannel channel, String userMessage);

    CommandType getCommandType();
}
