package me.mrbernard.cosmetics.inventory.implementation

import me.mrbernard.cosmetics.component
import me.mrbernard.cosmetics.config.Config
import me.mrbernard.cosmetics.inventory.ContainerInventory
import me.mrbernard.cosmetics.inventory.InteractiveItemStack
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CosmeticInventory : ContainerInventory() {

    override fun renderCurrentPage() {
        super.renderCurrentPage()

        val isNextPageAvailable = currentPage < pagedItems.size - 1
        val isPreviousPageAvailable = currentPage > 0

        val nextPageItem = Config.COSMETIC_INVENTORY_CONFIG?.buttons?.nextPage?.item ?: ItemStack(Material.ARROW)
        val previousPageItem = Config.COSMETIC_INVENTORY_CONFIG?.buttons?.previousPage?.item ?: ItemStack(Material.ARROW)

        val nextPageTitle = if (isNextPageAvailable) Config.COSMETIC_INVENTORY_CONFIG?.buttons?.nextPage?.name?.component else
            Config.COSMETIC_INVENTORY_CONFIG?.buttons?.nextPage?.nameUnavailable?.component
        val previousPageTitle = if (isPreviousPageAvailable) Config.COSMETIC_INVENTORY_CONFIG?.buttons?.previousPage?.name?.
        component else Config.COSMETIC_INVENTORY_CONFIG?.buttons?.previousPage?.nameUnavailable?.component

        setItem(calculateSlot(topLeft[0], bottomRight[1] + 1), InteractiveItemStack(
            nextPageItem,
            nextPageTitle
        ).onLeftClick {
            if (isNextPageAvailable) {
                currentPage++
                renderCurrentPage()
            }
            isCancelled = true
        })
        setItem(calculateSlot(bottomRight[0], bottomRight[1] + 1), InteractiveItemStack(
            previousPageItem,
            previousPageTitle
        ).onLeftClick {
            if (isPreviousPageAvailable) {
                currentPage--
                renderCurrentPage()
            }
            isCancelled = true
        })
    }
}