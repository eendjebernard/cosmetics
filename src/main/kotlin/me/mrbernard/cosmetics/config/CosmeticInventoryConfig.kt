package me.mrbernard.cosmetics.config

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Setting

@ConfigSerializable
class CosmeticInventoryConfig {

    @Setting
    val buttons = PageButtonSection()

    @ConfigSerializable
    class PageButtonSection {

        var nextPage = NextPageButton()
        var previousPage = PreviousPageButton()

        @ConfigSerializable
        class NextPageButton {

            var name = "<#0097FF>Next Page"
            var nameUnavailable = "<#0097FF>Next Page (unavailable)"
            var item = ItemStack(Material.ARROW)

        }

        @ConfigSerializable
        class PreviousPageButton {

            var name = "<#0097FF>Next Page"
            var nameUnavailable = "<#0097FF>Next Page (unavailable)"
            var item = ItemStack(Material.ARROW)

        }
    }
}