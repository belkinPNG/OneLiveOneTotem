package com.github.jiuuc.onelifeonetotem.eventlistener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.*;

public class PlayerDeathEvent implements Listener {
    @EventHandler
    public static void onDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player player = event.getPlayer();
        removeUsedTotemData(player);
        resetTotemCooldown(player);
    }
}
