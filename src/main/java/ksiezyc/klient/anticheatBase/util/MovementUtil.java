package ksiezyc.klient.anticheatBase.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementUtil {
    private PlayerMoveEvent event;

    public MovementUtil(PlayerMoveEvent event) {
        this.event = event;
    }

    public Location getFrom() {
        return event.getFrom();
    }

    public Location getTo() {
        return event.getTo();
    }

    public Player getPlayer() {
        return event.getPlayer();
    }

    public void setCancelled(boolean cancelled) {
        event.setCancelled(cancelled);
    }

    public void cancel() {
        event.setCancelled(true);
    }

    public double getXdelta() {
        return event.getTo().getX() - event.getFrom().getX();
    }

    public double getYdelta() {
        return event.getTo().getY() - event.getFrom().getY();
    }

    public double getZdelta() {
        return event.getTo().getZ() - event.getFrom().getZ();
    }

    public double getYawDelta() {
        return event.getTo().getYaw() - event.getFrom().getY();
    }

    public double getPitchDelta() {
        return event.getTo().getPitch() - event.getFrom().getPitch();
    }

    public double calculateSpeed() {
        double mX = getXdelta();
        double mZ = getZdelta();
        return Math.sqrt(mX * mX + mZ * mZ);
    }

    public boolean canBeOnGround(float yPrecision) {
        return LocationUtils.canBeOnGround(event.getPlayer().getLocation(), yPrecision);
    }

}
