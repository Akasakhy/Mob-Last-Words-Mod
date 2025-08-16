package com.example.moblastwords.event;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import com.example.moblastwords.util.LastWordsMessages;
import com.example.moblastwords.init.ModSounds;
import net.minecraft.ChatFormatting;
import java.util.Random;

public class MobDeathEventHandler {
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void onMobDeath(LivingDeathEvent event) {
        LivingEntity deadEntity = event.getEntity();

        // Mobエンティティのみ対象（プレイヤー以外なら誰が倒してもOK）
        if (!(deadEntity instanceof Mob)) {
            return;
        }

        // サーバーサイドでのみ実行
        if (deadEntity.level().isClientSide()) {
            return;
        }

        ServerLevel serverLevel = (ServerLevel) deadEntity.level();

        // モブの名前を取得（カスタム名がある場合はそちらを優先）
        String mobName = deadEntity.hasCustomName() ?
                deadEntity.getCustomName().getString() :
                deadEntity.getType().getDescription().getString();

        // ランダムなメッセージを取得（翻訳キーを使用）
        Component lastWordsComponent = LastWordsMessages.getRandomTranslatableMessage();

        // チャットメッセージを作成（赤色、翻訳対応）
        Component chatMessage = Component.literal("[" + mobName + "]: ")
                .withStyle(ChatFormatting.RED)
                .append(lastWordsComponent.copy().withStyle(ChatFormatting.RED));

        // 近くのプレイヤー全員にメッセージを送信
        for (ServerPlayer player : serverLevel.getPlayers(serverPlayer ->
                serverPlayer.distanceToSqr(deadEntity) <= 50 * 50)) { // 50ブロック以内
            player.sendSystemMessage(chatMessage);
        }

        // ランダムな音を再生
        deadEntity.level().playSound(
                null,
                deadEntity.getX(),
                deadEntity.getY(),
                deadEntity.getZ(),
                ModSounds.getRandomSound().value(),
                SoundSource.NEUTRAL,
                1.0F,
                1.0F
        );

//        // パーティクル爆発エフェクトを作成（15ブロック上空）
//        createFireworkEffect(serverLevel, deadEntity.getX(), deadEntity.getY() + 1, deadEntity.getZ());
//    }
//
//    private void createFireworkEffect(ServerLevel level, double x, double y, double z) {
//        // カラフルなパーティクル爆発エフェクトを作成
//        // 複数の爆発パーティクルを生成
//        for (int i = 0; i < 50; i++) {
//            double offsetX = (RANDOM.nextDouble() - 0.5) * 8.0;
//            double offsetY = (RANDOM.nextDouble() - 0.5) * 8.0;
//            double offsetZ = (RANDOM.nextDouble() - 0.5) * 8.0;
//
//            double velocityX = (RANDOM.nextDouble() - 0.5) * 0.5;
//            double velocityY = (RANDOM.nextDouble() - 0.5) * 0.5;
//            double velocityZ = (RANDOM.nextDouble() - 0.5) * 0.5;
//
//            // 花火パーティクル
//            level.sendParticles(
//                    ParticleTypes.FIREWORK,
//                    x + offsetX, y + offsetY, z + offsetZ,
//                    1, // パーティクル数
//                    velocityX, velocityY, velocityZ, // 速度
//                    0.1 // 追加データ
//            );
//        }
//
//        // 大きな爆発エフェクト
//        for (int i = 0; i < 20; i++) {
//            double offsetX = (RANDOM.nextDouble() - 0.5) * 6.0;
//            double offsetY = (RANDOM.nextDouble() - 0.5) * 6.0;
//            double offsetZ = (RANDOM.nextDouble() - 0.5) * 6.0;
//
//            // 爆発パーティクル
//            level.sendParticles(
//                    ParticleTypes.EXPLOSION,
//                    x + offsetX, y + offsetY, z + offsetZ,
//                    1, // パーティクル数
//                    0, 0, 0, // 速度
//                    0.0 // 追加データ
//            );
//        }
//
//        // カラフルなハート型パーティクル（追加エフェクト）
//        for (int i = 0; i < 30; i++) {
//            double offsetX = (RANDOM.nextDouble() - 0.5) * 10.0;
//            double offsetY = (RANDOM.nextDouble() - 0.5) * 10.0;
//            double offsetZ = (RANDOM.nextDouble() - 0.5) * 10.0;
//
//            double velocityX = (RANDOM.nextDouble() - 0.5) * 0.3;
//            double velocityY = RANDOM.nextDouble() * 0.3;
//            double velocityZ = (RANDOM.nextDouble() - 0.5) * 0.3;
//
//            // ハートパーティクル
//            level.sendParticles(
//                    ParticleTypes.HEART,
//                    x + offsetX, y + offsetY, z + offsetZ,
//                    1, // パーティクル数
//                    velocityX, velocityY, velocityZ, // 速度
//                    0.0 // 追加データ
//            );
//        }
//
//        // エンドロッドパーティクル（白い光）
//        for (int i = 0; i < 15; i++) {
//            double offsetX = (RANDOM.nextDouble() - 0.5) * 12.0;
//            double offsetY = (RANDOM.nextDouble() - 0.5) * 12.0;
//            double offsetZ = (RANDOM.nextDouble() - 0.5) * 12.0;
//
//            double velocityX = (RANDOM.nextDouble() - 0.5) * 0.2;
//            double velocityY = (RANDOM.nextDouble() - 0.5) * 0.2;
//            double velocityZ = (RANDOM.nextDouble() - 0.5) * 0.2;
//
//            // エンドロッドパーティクル
//            level.sendParticles(
//                    ParticleTypes.END_ROD,
//                    x + offsetX, y + offsetY, z + offsetZ,
//                    1, // パーティクル数
//                    velocityX, velocityY, velocityZ, // 速度
//                    0.0 // 追加データ
//            );
//        }
    }
}