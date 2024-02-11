package me.mrbernard.cosmetics.command

import me.mrbernard.cosmetics.Cosmetics
import revxrsal.commands.bukkit.BukkitCommandHandler

object CommandManager {

    private val commandHandler: BukkitCommandHandler = BukkitCommandHandler.create(Cosmetics.INSTANCE)

    init {

        commandHandler.register(PingCommand())
    }
}