package ksiezyc.klient.anticheatBase.checks.impl;

import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import ksiezyc.klient.anticheatBase.checks.Check;
import ksiezyc.klient.anticheatBase.util.ChatUtil;
import ksiezyc.klient.anticheatBase.util.MovementUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class ExampleCheck extends Check {

    public ExampleCheck() {
        super("Example check", 15);
    }

    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent event) {
        //Here you receive packets from player
    }

    @Override
    public void onTick() {
        //This method is called every tick
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        //Called when player moves

        //Creating movement util
        MovementUtil util = new MovementUtil(event);
    }


    //Just examples
    //You can delete it
    private void examples() {
        Player p = Bukkit.getPlayer("Notch");

        //Call it when player flags
        executeAction(p);

        //Send message only to players with selected permission (and opped players)
        ChatUtil.sendOnlyPermission("Test", "Anticheat.permission");

    }

}
