plugins {
    java
}

group = "com.owen1212055"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://repo.codemc.io/repository/nms/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.14-R0.1-SNAPSHOT") {
        isTransitive = false
    }
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0") {
        isTransitive = false
    }
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(8)
    }
}