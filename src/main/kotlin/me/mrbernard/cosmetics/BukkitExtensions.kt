package me.mrbernard.cosmetics

import net.kyori.adventure.text.minimessage.MiniMessage

val String.component
    get() = MiniMessage.miniMessage().deserialize(this)