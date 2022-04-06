package ksiezyc.klient.anticheatBase.checks;

import ksiezyc.klient.anticheatBase.AntiCheat;
import ksiezyc.klient.anticheatBase.checks.impl.ExampleCheck;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class CheckManager {
    public static ArrayList<Check> checks = new ArrayList<Check>();

    public void init() {

        //Here you add the checks
        checks.add(new ExampleCheck());


        //Here you register checks events
        for(Check c : checks) {
            AntiCheat.instance.packetEvents.get().registerListener(c);
            Bukkit.getServer().getPluginManager().registerEvents(c, AntiCheat.instance);
        }
    }

    public Check getCheckByName(String name) {
        return checks.stream().filter(check -> check.getName().equalsIgnoreCase(name)).findFirst().get();
    }
}
