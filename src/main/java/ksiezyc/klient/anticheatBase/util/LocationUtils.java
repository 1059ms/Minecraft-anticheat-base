package ksiezyc.klient.anticheatBase.util;

import org.bukkit.Location;
import org.bukkit.Material;

public class LocationUtils {

    public static boolean canBeOnGround(Location loc, float yPrecision) {
        for (float x = -0.5f; x <= 0.5f; x += 0.5f) {
            for (float z = -0.5f; z <= 0.5f; z += 0.5f) {
                if (loc.clone().add(x, -yPrecision, z).getBlock().getType() != Material.AIR) return true;
            }
        }
        return false;
    }

}
