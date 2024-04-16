package com.github.jiuuc.onelifeonetotem;

import com.github.jiuuc.onelifeonetotem.eventlistener.PlayerDeathEvent;
import com.github.jiuuc.onelifeonetotem.eventlistener.SetTotemCooldownEvent;
import com.github.jiuuc.onelifeonetotem.eventlistener.SleepEvent;
import com.github.jiuuc.onelifeonetotem.eventlistener.SweetDreamsSleepEvent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;
    public static NamespacedKey coolDownKey;
    public static final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        coolDownKey = new NamespacedKey(instance, "usedTotem");

        pluginManager.registerEvents(new SetTotemCooldownEvent(), this);
        pluginManager.registerEvents(new PlayerDeathEvent(), this);

        if (getConfig().getBoolean("reload-after-sleeping")) {
            try {
                registerPlayerSleepEvent();
            } catch (Exception e) {
               e.printStackTrace();
               pluginManager.disablePlugin(this);
            }
        }
    }

    private void registerPlayerSleepEvent() throws Exception {
        Class<? extends Listener> eventClass = pluginManager.isPluginEnabled("SweetDreams") ?
                SweetDreamsSleepEvent.class : SleepEvent.class;
        pluginManager.registerEvents(eventClass.getDeclaredConstructor().newInstance(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
