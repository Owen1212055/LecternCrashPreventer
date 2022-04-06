package com.owen1212055.lecterncrashpreventer;

import com.comphenix.protocol.*;
import com.comphenix.protocol.events.*;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.plugin.java.*;

public final class LecternCrashPreventer extends JavaPlugin {

    @Override
    public void onEnable() {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ListenerPriority.HIGHEST, PacketType.Play.Client.WINDOW_CLICK) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
                if (player == null) {
                    return;
                }

                if (player.getOpenInventory().getType() == InventoryType.LECTERN && event.getPacket().getEnumModifier(ClickType.class, 5).read(0) == ClickType.QUICK_MOVE) {
                    event.setCancelled(true);
                    System.out.println("Prevented lectern crash from " + player.getName());
                }
            }
        });
    }

    public enum ClickType {
        PICKUP,
        QUICK_MOVE,
        SWAP,
        CLONE,
        THROW,
        QUICK_CRAFT,
        PICKUP_ALL;
    }

}
