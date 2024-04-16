package com.github.jiuuc.onelifeonetotem.eventlistener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.github.jiuuc.onelifeonetotem.util.CooldownUtils.*;

public class SetTotemCooldownEvent implements Listener {

    @EventHandler
    public void onTotemUse(EntityResurrectEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;

        if (!isTotemUsed(player)) {
            setUsedTotemData(player);
            setTotemCooldown(player);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (isTotemUsed(player)) {
            setTotemCooldown(player);
        }
    }

    @EventHandler
    public void onPlayerWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        if (isTotemUsed(player)) {
            setTotemCooldown(player);
        }
    }
}
