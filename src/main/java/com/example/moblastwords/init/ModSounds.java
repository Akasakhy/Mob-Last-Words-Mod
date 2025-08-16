package com.example.moblastwords.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.example.moblastwords.MobLastWords;

import java.util.List;
import java.util.Random;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MobLastWords.MOD_ID);

    private static final Random RANDOM = new Random();

    // 9種類のモブ死亡時の音
    public static final Holder<SoundEvent> MOB_DEATH_1 = SOUND_EVENTS.register(
            "mob_death_1",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_2 = SOUND_EVENTS.register(
            "mob_death_2",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_3 = SOUND_EVENTS.register(
            "mob_death_3",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_4 = SOUND_EVENTS.register(
            "mob_death_4",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_5 = SOUND_EVENTS.register(
            "mob_death_5",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_6 = SOUND_EVENTS.register(
            "mob_death_6",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_7 = SOUND_EVENTS.register(
            "mob_death_7",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_8 = SOUND_EVENTS.register(
            "mob_death_8",
            SoundEvent::createVariableRangeEvent
    );

    public static final Holder<SoundEvent> MOB_DEATH_9 = SOUND_EVENTS.register(
            "mob_death_9",
            SoundEvent::createVariableRangeEvent
    );

    // 5つの音からランダムに1つを取得するメソッド
    private static final List<Holder<SoundEvent>> SOUNDS = List.of(
            MOB_DEATH_1, MOB_DEATH_2, MOB_DEATH_3, MOB_DEATH_4, MOB_DEATH_5, MOB_DEATH_6, MOB_DEATH_7, MOB_DEATH_8, MOB_DEATH_9
    );

    public static Holder<SoundEvent> getRandomSound() {
        return SOUNDS.get(RANDOM.nextInt(SOUNDS.size()));
    }
}