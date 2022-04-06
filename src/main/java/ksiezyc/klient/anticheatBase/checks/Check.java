package ksiezyc.klient.anticheatBase.checks;

import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import ksiezyc.klient.anticheatBase.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class Check extends PacketListenerAbstract implements Listener {
    private String name;
    private int maxVL;
    public HashMap<Player, Integer> vl = new HashMap<Player, Integer>();

    public Check(String name, int maxVL) {
        this.name = name;
        this.maxVL = maxVL;
    }

    public void executeAction(Player p) {
        if(p.getTicksLived() < 5) return;
        if(vl.get(p) == null) vl.put(p, 0);
        vl.put(p, vl.get(p) + 1);
        ChatUtil.alert(p, this);

        if(vl.get(p) >= maxVL) {
            p.kickPlayer("§7[§c§lAntiCheat§7] §eYou got kicked for §e§l" + name);
            vl.put(p, 0);
        }
    }

    public int getMaxVL() {
        return maxVL;
    }

    public void onTick() {

    }

    public void setMaxVL(int maxVl) {
        this.maxVL = maxVl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
