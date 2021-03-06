package com.github.jensschulze.donotkill;

import org.bukkit.plugin.java.JavaPlugin;

public class DoNotKill extends JavaPlugin {
    @Override
    public void onEnable() {
        new DamageEventListener(this);
    }
}
