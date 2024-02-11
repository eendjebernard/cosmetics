package me.mrbernard.cosmetics.listener

import me.mrbernard.cosmetics.component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {

    @EventHandler
    fun handle(event: PlayerJoinEvent) {
        event.joinMessage("<gray>${event.player.name} joined".component)
    }
}