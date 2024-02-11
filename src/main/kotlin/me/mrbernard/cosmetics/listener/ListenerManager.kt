package me.mrbernard.cosmetics.listener

import me.mrbernard.cosmetics.Cosmetics
import org.bukkit.Bukkit

object ListenerManager {

    init {

        Bukkit.getServer().pluginManager.apply {
            registerEvents(PlayerJoinListener(), Cosmetics.INSTANCE)
        }
    }
}