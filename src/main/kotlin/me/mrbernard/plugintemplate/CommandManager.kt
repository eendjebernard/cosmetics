package me.mrbernard.plugintemplate

import me.mrbernard.plugintemplate.command.PingCommand
import revxrsal.commands.bukkit.BukkitCommandHandler

object CommandManager {

    var commandHandler: BukkitCommandHandler = BukkitCommandHandler.create(PluginTemplate.INSTANCE)

    init {

        commandHandler.register(PingCommand())
    }
}