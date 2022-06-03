package online.viestudio.paperkit.bukkit

import online.viestudio.paperkit.nms.nmsVersion
import org.bukkit.Server

internal val Server.craftSchedulerTickField
    get() = craftSchedulerClazz.getDeclaredField("currentTick").apply {
        isAccessible = true
    }

internal val Server.craftSchedulerHeartBeatMethod
    get() = craftSchedulerClazz.getDeclaredMethod("mainThreadHeartbeat", Int::class.java)

internal val Server.craftSchedulerClazz
    get() = Class.forName(
        "org.bukkit.craftbukkit.%s.scheduler.CraftScheduler".format(
            nmsVersion
        )
    )

