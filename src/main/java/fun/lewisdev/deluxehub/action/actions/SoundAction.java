package fun.lewisdev.deluxehub.action.actions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.action.Action;
import fun.lewisdev.deluxehub.utility.universal.XSound;

public class SoundAction implements Action {

    @Override
    public String getIdentifier() {
        return "SOUND";
    }

    @Override
    public void execute(DeluxeHubPlugin plugin, Player player, String data) {
        try {
            XSound.matchXSound(data).ifPresent(s -> player.playSound(player.getLocation(), s.parseSound(), 1L, 1L));
        } catch (Exception ex) {
            Bukkit.getLogger().warning("[DeluxeHub Action] Invalid sound name: " + data.toUpperCase());
        }
    }
}
