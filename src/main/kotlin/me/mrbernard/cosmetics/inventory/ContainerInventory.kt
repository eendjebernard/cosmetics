package me.mrbernard.cosmetics.inventory

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.joml.Vector2i

open class ContainerInventory : InteractiveInventory() {

    protected val pagedItems = mutableListOf<MutableList<ItemStack>>()

    protected var topLeft = arrayOf(0, 0)
    protected var bottomRight = arrayOf(0, 0)

    private var items = 0
    private var itemsPerRow = 0
    private var itemsPerPage = 0
    protected var currentPage = 0

    fun setContainerBounds(topLeft: Vector2i, bottomRight: Vector2i) {
        this.topLeft = arrayOf(topLeft.x, topLeft.y)
        this.bottomRight = arrayOf(bottomRight.x, bottomRight.y)

        // Calculates how many items a row can have and then multiplies the number of rows with the number of items
        // a row can have to get the number of items a page can have
        itemsPerRow = bottomRight.x + 1 - topLeft.x
        itemsPerPage = (bottomRight.y + 1 - topLeft.y) * itemsPerRow
    }

    fun addItem(item: ItemStack) {
        // Retrieves the correct last page items list. If the list does not exist yet, the list gets created. If it
        // already exists, it changes the value to the one in the 'pagedItems' field
        val lastPageItems: MutableList<ItemStack>
        if (pagedItems.isEmpty()) {
            lastPageItems = mutableListOf()
            pagedItems.add(lastPageItems)
        } else lastPageItems = pagedItems[pagedItems.size - 1]

        // Checks if the current last page is full. If it is, it creates a new page and adds the item to that one. If
        // not, it adds the item to the current last page
        if (lastPageItems.size == itemsPerPage) {
            val newPageItems = mutableListOf<ItemStack>()
            newPageItems.add(item)
            pagedItems.add(newPageItems)
        } else lastPageItems.add(item)
        renderCurrentPage()
    }

    protected open fun renderCurrentPage() {
        menuInventory.clear()

        val currentPageItems = pagedItems[currentPage]

        for (i in currentPageItems.indices) {
            menuInventory.setItem(
                calculateSlot(i % itemsPerRow + topLeft[0], i / itemsPerRow + topLeft[1]),
                currentPageItems[i]
            )
        }
    }

    protected fun calculateSlot(x: Int, y: Int) = y * 9 + x

    override fun getInventory(): Inventory {
        renderCurrentPage()
        return super.getInventory()
    }
}