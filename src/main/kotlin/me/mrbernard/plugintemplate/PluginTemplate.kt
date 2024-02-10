package me.mrbernard.plugintemplate

import org.bukkit.plugin.java.JavaPlugin

class PluginTemplate : JavaPlugin() {

    companion object {

        lateinit var INSTANCE: PluginTemplate

    }

    override fun onEnable() {
        INSTANCE = this

        CommandManager
        ListenerManager
    }
}