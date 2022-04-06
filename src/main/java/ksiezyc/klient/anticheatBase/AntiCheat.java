package ksiezyc.klient.anticheatBase;

import io.github.retrooper.packetevents.PacketEvents;
import ksiezyc.klient.anticheatBase.checks.CheckManager;
import ksiezyc.klient.anticheatBase.util.Loop;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin implements Listener {
    public static AntiCheat instance = new AntiCheat();

    public PacketEvents packetEvents = new PacketEvents();
    public CheckManager checkManager = new CheckManager();

    @Override
    public void onLoad() {
        packetEvents.create(this).getSettings().checkForUpdates(false);
        packetEvents.get().load();
    }

    @Override
    public void onEnable() {
        packetEvents.get().init();
        getServer().getPluginManager().registerEvents(this, this);
        Loop.startLoop();
        checkManager.init();
    }

    @Override
    public void onDisable() {
        packetEvents.get().stop();
    }

}
