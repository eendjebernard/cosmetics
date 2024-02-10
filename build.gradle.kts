plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperweight)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.plugin.yml)
}

group = "me.mrbernard.plugintemplate"
version = "1.0"
description = "Easy and fast plugin template with all the important libraries already imported"

repositories {
    maven("https://jitpack.io")
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation(libs.lamp.common)
    implementation(libs.lamp.bukkit)
}

tasks {
    assemble { dependsOn(shadowJar) }
    compileKotlin { kotlinOptions.jvmTarget = "17" }
}

bukkit {
    name = "PluginTemplate"
    main = "me.mrbernard.plugintemplate.PluginTemplate"
    apiVersion = "1.20.4"
    authors = listOf("Mr_Bernard_")
}