package me.mrbernard.cosmetics

import me.mrbernard.cosmetics.listener.PlayerJoinListener
import org.bukkit.Bukkit

object ListenerManager {

    init {

        Bukkit.getServer().pluginManager.apply {
            registerEvents(PlayerJoinListener(), Cosmetics.INSTANCE)
        }
    }
}