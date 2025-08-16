package com.example.moblastwords.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LastWordsMessages {
    private static final Random RANDOM = new Random();

    private static final List<String> LAST_WORDS = new ArrayList<>();

    static {
        // 5種類のメッセージを追加
        LAST_WORDS.add("なんでそんなことするの...");
        LAST_WORDS.add("痛いよ...もうやめて...");
        LAST_WORDS.add("僕たちにも家族がいるんだ...");
        LAST_WORDS.add("ただ平和に暮らしていただけなのに...");
        LAST_WORDS.add("次に生まれ変わったら友達になろうね...");
    }

    public static String getRandomMessage() {
        if (LAST_WORDS.isEmpty()) {
            return "...";
        }
        return LAST_WORDS.get(RANDOM.nextInt(LAST_WORDS.size()));
    }

    // 新しいメッセージを追加するためのメソッド（将来の拡張用）
    public static void addMessage(String message) {
        if (message != null && !message.trim().isEmpty()) {
            LAST_WORDS.add(message);
        }
    }
}