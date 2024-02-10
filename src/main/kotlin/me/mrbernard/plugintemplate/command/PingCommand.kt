package me.mrbernard.plugintemplate.command

import net.kyori.adventure.text.Component
import revxrsal.commands.annotation.Command
import revxrsal.commands.bukkit.BukkitCommandActor

class PingCommand {

    @Command("ping")
    fun defaultResponse(actor: BukkitCommandActor) = actor.requirePlayer().sendMessage(Component.text("Pong!"))
}