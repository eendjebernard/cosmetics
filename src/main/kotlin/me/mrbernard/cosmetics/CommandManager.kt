package me.mrbernard.cosmetics

import me.mrbernard.cosmetics.command.PingCommand
import revxrsal.commands.bukkit.BukkitCommandHandler

object CommandManager {

    private val commandHandler: BukkitCommandHandler = BukkitCommandHandler.create(Cosmetics.INSTANCE)

    init {

        commandHandler.register(PingCommand())
    }
}