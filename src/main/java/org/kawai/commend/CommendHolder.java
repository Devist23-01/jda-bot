package org.kawai.commend;

import org.kawai.config.Commendable;

import java.util.HashMap;
import java.util.Map;

public class CommendHolder {
    private static CommendHolder INSTANCE = null;
    private Map<CommendType, Commendable> commendableMap = new HashMap<>();

    private CommendHolder() {
    }

    public static CommendHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommendHolder();
        }
        return INSTANCE;
    }

    public Map<CommendType, Commendable> getCommendableMap() {
        return commendableMap;
    }

}
