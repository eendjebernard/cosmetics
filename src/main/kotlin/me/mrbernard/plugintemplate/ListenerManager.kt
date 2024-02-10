package me.mrbernard.plugintemplate

import me.mrbernard.plugintemplate.listener.PlayerJoinListener
import org.bukkit.Bukkit

object ListenerManager {

    init {

        Bukkit.getServer().pluginManager.apply {
            registerEvents(PlayerJoinListener(), PluginTemplate.INSTANCE)
        }
    }
}