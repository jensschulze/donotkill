package com.github.jensschulze.donotkill;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEventListener implements Listener {

    public DamageEventListener(DoNotKill plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDamagedByPlayer(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damagee = event.getEntity();
        if (!(damager instanceof Player && damagee instanceof Player)) {
            return;
        }

        event.setCancelled(true);

        damager.sendMessage(((Player) damager).getDisplayName() + ", :-(");
        ((Player) damager).damage(event.getDamage());
    }
}
