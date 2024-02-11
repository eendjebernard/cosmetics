package me.mrbernard.cosmetics.inventory

import me.mrbernard.cosmetics.Cosmetics
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.InventoryHolder

open class InteractiveInventory() : InventoryHolder, Listener {

    val menuInventory = Bukkit.createInventory(this, 9 * 6)
    private val itemsPerSlot = hashMapOf<Int, InteractiveItemStack>()

    private var onCloseAction: InventoryCloseEvent.() -> Unit = {}

    init {
        registerAsListener()
    }

    @EventHandler
    fun onClose(event: InventoryCloseEvent) {
        if (event.inventory.holder != this) return
        onCloseAction(event)
    }

    @EventHandler
    fun onClick(event: InventoryClickEvent) {
        if (event.whoClicked !is Player) return
        if (event.inventory.holder != this) return

        val item = itemsPerSlot[event.slot]
        item?.onClickAction?.let { it(event) }
        if (event.click == ClickType.LEFT) item?.onLeftClickAction?.let { it(event) }
        else if (event.click == ClickType.RIGHT) item?.onRightClickAction?.let { it(event) }
    }

    fun setItem(slot: Int, item: InteractiveItemStack) {
        menuInventory.setItem(slot, item.build())
        itemsPerSlot[slot] = item
    }

    fun onClose(action: InventoryCloseEvent.() -> Unit): InteractiveInventory {
        onCloseAction = action
        return this
    }

    fun registerAsListener() = Bukkit.getServer().pluginManager.registerEvents(this, Cosmetics.INSTANCE)

    override fun getInventory() = menuInventory
}