package com.github.jiuuc.onelifeonetotem.eventlistener;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.removeUsedTotemData;
import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.resetTotemCooldown;

public class SleepEvent implements Listener {
    @EventHandler
    public static void onSleep(TimeSkipEvent event) {
        if (event.getSkipReason() != TimeSkipEvent.SkipReason.NIGHT_SKIP) return;

        Bukkit.getOnlinePlayers().stream().parallel().filter(LivingEntity::isSleeping).forEach(player -> {
            removeUsedTotemData(player);
            resetTotemCooldown(player);
        });
    }
}
