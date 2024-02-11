package me.mrbernard.cosmetics.command

import me.mrbernard.cosmetics.inventory.implementation.CosmeticInventory
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.joml.Vector2i
import revxrsal.commands.annotation.Command
import revxrsal.commands.bukkit.BukkitCommandActor

class PingCommand {

    @Command("ping")
    fun defaultResponse(actor: BukkitCommandActor) {
        val inventory = CosmeticInventory()
        inventory.setContainerBounds(Vector2i(3, 1), Vector2i(5, 3))
        inventory.addItem(ItemStack(Material.DIAMOND))
        actor.requirePlayer().openInventory(inventory.inventory)
    }
}