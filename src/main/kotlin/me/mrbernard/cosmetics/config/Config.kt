package me.mrbernard.cosmetics.config

import me.mrbernard.cosmetics.Cosmetics
import me.mrbernard.cosmetics.config.serializer.ItemStackSerializer
import org.bukkit.inventory.ItemStack
import org.spongepowered.configurate.CommentedConfigurationNode
import org.spongepowered.configurate.hocon.HoconConfigurationLoader
import java.io.File

/** Very (not) advanced config system using Sponge's Configurate library to read and write .conf (HOCON) format files */
class Config<T>(file: File, private val t: Class<T>) {

    companion object {

        val COSMETIC_INVENTORY = Config(File(Cosmetics.INSTANCE.dataFolder, "cosmetic_inventory.conf"),
            CosmeticInventoryConfig::class.java)
        val COSMETIC_INVENTORY_CONFIG = COSMETIC_INVENTORY.config
    }

    private val loader = HoconConfigurationLoader.builder()
        .file(file)
        .defaultOptions { opts ->
            opts.serializers { build ->
                build.register(ItemStack::class.java, ItemStackSerializer.INSTANCE)
            }
        }
        .build()
    private val node = loader.load()

    val config = if (loader.canLoad()) node.get(t) else t.newInstance()

    init {
        if (!file.exists()) {
            file.createNewFile()
            loader.save(CommentedConfigurationNode.factory().createNode().set(config))
        }
    }

    fun save() {
        node.set(t, config)
        loader.save(node)
    }
}