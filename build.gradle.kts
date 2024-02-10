plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperweight)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.plugin.yml)
}

group = "me.mrbernard.cosmetics"
version = "1.0"

repositories {
    maven("https://jitpack.io")
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation(libs.lamp.common)
    implementation(libs.lamp.bukkit)

    implementation(libs.configurate.core)
    implementation(libs.configurate.hocon)
}

tasks {
    assemble { dependsOn(shadowJar) }
    compileKotlin { kotlinOptions.jvmTarget = "17" }
}

bukkit {
    name = "Cosmetics"
    main = "me.mrbernard.cosmetics.Cosmetics"
    apiVersion = "1.20.4"
    authors = listOf("Mr_Bernard_")
}