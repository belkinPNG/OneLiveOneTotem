package com.github.jiuuc.onelifeonetotem.eventlistener;

import com.creray.sweetdreams.event.NightSkippedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.removeUsedTotemData;
import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.resetTotemCooldown;

public class SweetDreamsSleepEvent implements Listener {
    @EventHandler
    public static void onSleep(NightSkippedEvent event) {
        event.getSleptPlayers().stream().parallel().forEach(player -> {
            removeUsedTotemData(player);
            resetTotemCooldown(player);
        });
    }
}
