package com.example.moblastwords;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import com.example.moblastwords.event.MobDeathEventHandler;
import com.example.moblastwords.init.ModSounds;

@Mod(MobLastWords.MOD_ID)
public class MobLastWords {
    public static final String MOD_ID = "moblastwords";

    public MobLastWords(IEventBus modEventBus, ModContainer modContainer) {
        // 音の登録
        ModSounds.SOUND_EVENTS.register(modEventBus);

        // イベントハンドラーをForgeイベントバスに登録
        NeoForge.EVENT_BUS.register(new MobDeathEventHandler());
    }
}