package me.mrbernard.cosmetics.config.serializer

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

class ItemStackSerializer : TypeSerializer<ItemStack> {

    companion object {

        val INSTANCE = ItemStackSerializer()
    }

    override fun deserialize(type: Type?, node: ConfigurationNode): ItemStack {
        if (node.empty()) return ItemStack(Material.AIR)

        val material = Material.valueOf(node.node("material").string?.uppercase() ?: return ItemStack(Material.AIR))
        val customModelData = node.node("customModelData").int

        return ItemStack(material).apply {
            editMeta {
                it.setCustomModelData(customModelData)
            }
        }
    }

    override fun serialize(type: Type?, obj: ItemStack?, node: ConfigurationNode?) {
        node?.node("material")?.set(obj?.type)
        node?.node("customModelData")?.set(if (obj?.itemMeta?.hasCustomModelData() == true) obj.itemMeta.customModelData else 0)
    }
}