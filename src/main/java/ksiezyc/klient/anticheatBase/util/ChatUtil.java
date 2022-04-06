package ksiezyc.klient.anticheatBase.util;

import ksiezyc.klient.anticheatBase.checks.Check;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {

    public static String colorFix(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }

    public static void alert(Player p, Check c) {
        sendOnlyPermission("§7[§cAntiCheeto§7] §7" + p.getName() + "§e failed " + c.getName() + " §7[§eVL " + c.vl.get(p) + "/" + c.getMaxVL() + "§7]", "Anticheeto.alerts");
    }

    public static void sendOnlyPermission(String msg, String permission) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.hasPermission(permission)) {
                p.sendMessage(msg);
            }
        }
    }

}
