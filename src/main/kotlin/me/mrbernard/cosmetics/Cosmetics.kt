package me.mrbernard.cosmetics

import me.mrbernard.cosmetics.command.CommandManager
import me.mrbernard.cosmetics.config.Config
import me.mrbernard.cosmetics.listener.ListenerManager
import org.bukkit.plugin.java.JavaPlugin

class Cosmetics : JavaPlugin() {

    companion object {

        lateinit var INSTANCE: Cosmetics

    }

    override fun onEnable() {
        INSTANCE = this

        CommandManager
        ListenerManager

        if (!dataFolder.exists()) dataFolder.mkdir()
    }

    override fun onDisable() {
        Config.COSMETIC_INVENTORY.save()
    }
}