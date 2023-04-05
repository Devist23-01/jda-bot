package org.kawai.config;

import org.kawai.commend.ReactionCommend;
import org.kawai.commend.RpsCommend;

import java.util.HashMap;
import java.util.Map;

public class CommendConfig {
    Map<String, Commendable> commendableMap = new HashMap<>();

    // new 로 생성자 만들때 이 메소드가 먼저 실행됨
    public CommendConfig() {
        commendableMap.put("!도박", new RpsCommend());
        commendableMap.put("", new ReactionCommend());
    }

    public Commendable getCommend(String commendPrefix) {
        if (commendableMap.containsKey(commendPrefix)) {
            return commendableMap.get(commendPrefix);
        } else {
            return commendableMap.get("");
        }
    }
}
