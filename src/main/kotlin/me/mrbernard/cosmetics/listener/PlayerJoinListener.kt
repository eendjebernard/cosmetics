package me.mrbernard.cosmetics.listener

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {

    private val String.component
        get() = MiniMessage.miniMessage().deserialize(this)

    @EventHandler
    fun handle(event: PlayerJoinEvent) {
        event.joinMessage("<gray>${event.player.name} joined".component)
    }
}