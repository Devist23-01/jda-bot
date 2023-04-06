package org.kawai.commend;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CommendType {
    REACTION(""),
    RPS("도박", "ㄷㅂ", "ㄷ", "rps"),
    IMAGE("코코미", "행크TS", "이로TS");
    // 이 상수들은 commendSet Array

    //    set == collection
    private final Set<String> commendSet = new HashSet<>();

    //    enum은 Runtime에서 실행함
    CommendType(String... commendSet) {
        this.commendSet.addAll(Arrays.asList(commendSet));
    }

    public static CommendType from(String command) {
        CommendType[] values = CommendType.values();
        for (CommendType value : values) {
            Set<String> commendSet = value.getCommendSet();
            for (String realCommend : commendSet) {
                if (realCommend.equals(command)) {
                    return value;
                }
            }
        }
        return REACTION;
    }

    public Set<String> getCommendSet() {
        return commendSet;
    }
}
