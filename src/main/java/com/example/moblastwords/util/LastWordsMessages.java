package com.example.moblastwords.util;

import net.minecraft.network.chat.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LastWordsMessages {
    private static final Random RANDOM = new Random();

    private static final List<String> TRANSLATION_KEYS = new ArrayList<>();

    static {
        // 5種類の翻訳キーを追加
        TRANSLATION_KEYS.add("moblastwords.message.last_words_1");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_2");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_3");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_4");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_5");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_6");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_7");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_8");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_9");
        TRANSLATION_KEYS.add("moblastwords.message.last_words_10");
    }

    /**
     * ランダムなメッセージの翻訳可能なコンポーネントを取得
     */
    public static Component getRandomTranslatableMessage() {
        if (TRANSLATION_KEYS.isEmpty()) {
            return Component.literal("...");
        }
        String translationKey = TRANSLATION_KEYS.get(RANDOM.nextInt(TRANSLATION_KEYS.size()));
        return Component.translatable(translationKey);
    }

    /**
     * 後方互換性のためのメソッド（非推奨）
     * @deprecated 代わりに getRandomTranslatableMessage() を使用してください
     */
    @Deprecated
    public static String getRandomMessage() {
        if (TRANSLATION_KEYS.isEmpty()) {
            return "...";
        }
        // フォールバック用の日本語メッセージ
        List<String> fallbackMessages = List.of(
                "なんでそんなことするの...",
                "痛いよ...もうやめて...",
                "僕たちにも家族がいるんだ...",
                "ただ平和に暮らしていただけなのに...",
                "次に生まれ変わったら友達になろうね..."
        );
        return fallbackMessages.get(RANDOM.nextInt(fallbackMessages.size()));
    }

    // 新しい翻訳キーを追加するためのメソッド（将来の拡張用）
    public static void addTranslationKey(String translationKey) {
        if (translationKey != null && !translationKey.trim().isEmpty()) {
            TRANSLATION_KEYS.add(translationKey);
        }
    }
}