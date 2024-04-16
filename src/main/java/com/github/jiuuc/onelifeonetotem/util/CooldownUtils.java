package com.github.jiuuc.onelifeonetotem.util;

import com.github.jiuuc.onelifeonetotem.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CooldownUtils {
    private static final int cooldownTime = Main.getInstance().getConfig().getInt("cooldown-time");
    public static boolean isTotemUsed(Player player) {
        PersistentDataContainer container = player.getPersistentDataContainer();

        if (!container.has(Main.coolDownKey)) {
            return false;
        } else {
            return container.get(Main.coolDownKey, PersistentDataType.BOOLEAN);
        }
    }

    public static void setUsedTotemData(Player player) {
        player.getPersistentDataContainer().set(Main.coolDownKey, PersistentDataType.BOOLEAN, true);
    }

    public static void removeUsedTotemData(Player player) {
        player.getPersistentDataContainer().remove(Main.coolDownKey);
    }
    public static void setTotemCooldown(Player player) {
        player.setCooldown(Material.TOTEM_OF_UNDYING, cooldownTime);
    }

    public static void resetTotemCooldown(Player player) {
        player.setCooldown(Material.TOTEM_OF_UNDYING, 0);
    }
}
