package me.mrbernard.cosmetics

import me.mrbernard.cosmetics.inventory.InteractiveItemStack
import net.kyori.adventure.text.Component
import org.bukkit.Material
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