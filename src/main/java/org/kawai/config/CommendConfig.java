package org.kawai.config;

import org.jetbrains.annotations.NotNull;
import org.kawai.commend.CommendHolder;
import org.kawai.commend.ImageCommend;
import org.kawai.commend.ReactionCommend;
import org.kawai.commend.RpsCommend;

import java.util.Arrays;
import java.util.List;

public class CommendConfig {

    public CommendConfig() {
        CommendHolder holder = CommendHolder.getInstance();
        List<Commendable> commendables = getCommendables();

        for (Commendable commendable : commendables) {
            holder.getCommendableMap()
                    .put(commendable.getCommendType(), commendable);
        }
    }

    @NotNull
    private static List<Commendable> getCommendables() {
        return Arrays.asList(
                new RpsCommend(),
                new ReactionCommend(),
                new ImageCommend()
        );
    }

}
