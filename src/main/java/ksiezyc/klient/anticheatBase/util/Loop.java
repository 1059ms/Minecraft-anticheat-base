package ksiezyc.klient.anticheatBase.util;

import ksiezyc.klient.anticheatBase.AntiCheat;
import ksiezyc.klient.anticheatBase.checks.Check;
import ksiezyc.klient.anticheatBase.checks.CheckManager;
import org.bukkit.Bukkit;

public class Loop {

    public static boolean islooprunning = false;

    public static int id;

    public static void startLoop() {
        islooprunning = true;
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(AntiCheat.instance, new Runnable() {
            @Override
            public void run() {
                for(Check c : CheckManager.checks) c.onTick();
            }
        },0,1);
    }

    public static void stopLoop() {
        islooprunning = false;
        Bukkit.getServer().getScheduler().cancelTask(id);
    }

}
