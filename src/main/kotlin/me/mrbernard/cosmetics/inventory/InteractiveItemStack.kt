package me.mrbernard.cosmetics.inventory

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class InteractiveItemStack(
    private val material: Material,
    private val displayName: Component = Component.empty(),
    private val lore: Array<Component> = arrayOf()
) {

    var onClickAction: InventoryClickEvent.() -> Unit = {}
    var onLeftClickAction: InventoryClickEvent.() -> Unit = {}
    var onRightClickAction: InventoryClickEvent.() -> Unit = {}

    fun onClick(action: InventoryClickEvent.() -> Unit): InteractiveItemStack {
        onClickAction = action
        return this
    }

    fun onLeftClick(action: InventoryClickEvent.() -> Unit): InteractiveItemStack {
        onLeftClickAction = action
        return this
    }

    fun onRightClick(action: InventoryClickEvent.() -> Unit): InteractiveItemStack {
        onRightClickAction = action
        return this
    }

    fun build() = ItemStack(material).apply {
        editMeta {
            it.displayName(displayName)
            it.lore(this@InteractiveItemStack.lore.toList())
        }
    }
}