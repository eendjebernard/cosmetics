package me.mrbernard.cosmetics

import org.bukkit.plugin.java.JavaPlugin

class Cosmetics : JavaPlugin() {

    companion object {

        lateinit var INSTANCE: Cosmetics

    }

    override fun onEnable() {
        INSTANCE = this

        CommandManager
        ListenerManager
    }
}