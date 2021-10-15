package fun.lewisdev.deluxehub.config;

import org.bukkit.configuration.file.FileConfiguration;

import fun.lewisdev.deluxehub.utility.TextUtil;

public enum Messages {
    PREFIX("GENERAL.PREFIX"), NO_PERMISSION("GENERAL.NO_PERMISSION"),
    CUSTOM_COMMAND_NO_PERMISSION("GENERAL.CUSTOM_COMMAND_NO_PERMISSION"), INVALID_PLAYER("GENERAL.INVALID_PLAYER"),
    CONFIG_RELOAD("GENERAL.CONFIG_RELOAD"), COOLDOWN_ACTIVE("GENERAL.COOLDOWN_ACTIVE"),

    GAMEMODE_CHANGE("GAMEMODE.GAMEMODE_CHANGE"), GAMEMODE_CHANGE_OTHER("GAMEMODE.GAMEMODE_CHANGE_OTHER"),
    GAMEMODE_INVALID("GAMEMODE.GAMEMODE_INVALID"),

    VANISH_ENABLE("VANISH.ENABLE"), VANISH_DISABLE("VANISH.DISABLE"),

    FLIGHT_ENABLE("FLIGHT.ENABLE"), FLIGHT_ENABLE_OTHER("FLIGHT.ENABLE_OTHER"), FLIGHT_DISABLE("FLIGHT.DISABLE"),
    FLIGHT_DISABLE_OTHER("FLIGHT.DISABLE_OTHER"),

    PLAYER_HIDER_HIDDEN("PLAYER_HIDER.HIDDEN"), PLAYER_HIDER_SHOWN("PLAYER_HIDER.SHOWN"),

    SET_LOBBY("LOBBY.SET_LOBBY"),

    CLEARCHAT("CHAT.CLEARCHAT"), CLEARCHAT_PLAYER("CHAT.CLEARCHAT_PLAYER"), CHAT_LOCKED("CHAT.LOCKED"),
    CHAT_LOCKED_BROADCAST("CHAT.LOCKED_BROADCAST"), CHAT_UNLOCKED_BROADCAST("CHAT.UNLOCKED_BROADCAST"),
    ANTI_SWEAR_WORD_BLOCKED("CHAT.ANTI_SWEAR_WORD_BLOCKED"), ANTI_SWEAR_ADMIN_NOTIFY("CHAT.ANTI_SWEAR_ADMIN_NOTIFY"),
    COMMAND_BLOCKED("CHAT.COMMAND_BLOCKED"),

    SCOREBOARD_TOGGLE("SCOREBOARD.TOGGLE"),

    DOUBLE_JUMP_COOLDOWN("DOUBLE_JUMP.COOLDOWN_ACTIVE"),

    EVENT_ITEM_DROP("WORLD_EVENT_MODIFICATIONS.ITEM_DROP"), EVENT_ITEM_PICKUP("WORLD_EVENT_MODIFICATIONS.ITEM_PICKUP"),
    EVENT_BLOCK_PLACE("WORLD_EVENT_MODIFICATIONS.BLOCK_PLACE"),
    EVENT_BLOCK_BREAK("WORLD_EVENT_MODIFICATIONS.BLOCK_BREAK"),
    EVENT_BLOCK_INTERACT("WORLD_EVENT_MODIFICATIONS.BLOCK_INTERACT"),
    EVENT_PLAYER_PVP("WORLD_EVENT_MODIFICATIONS.PLAYER_PVP"),

    HOLOGRAMS_EMPTY("HOLOGRAMS.EMPTY"), HOLOGRAMS_ALREADY_EXISTS("HOLOGRAMS.ALREADY_EXISTS"),
    HOLOGRAMS_INVALID_HOLOGRAM("HOLOGRAMS.INVALID_HOLOGRAM"), HOLOGRAMS_INVALID_LINE("HOLOGRAMS.INVALID_LINE"),
    HOLOGRAMS_SPAWNED("HOLOGRAMS.SPAWNED"), HOLOGRAMS_DESPAWNED("HOLOGRAMS.DESPAWNED"),
    HOLOGRAMS_MOVED("HOLOGRAMS.MOVED"), HOLOGRAMS_LINE_SET("HOLOGRAMS.LINE_SET"),
    HOLOGRAMS_ADDED_LINE("HOLOGRAMS.ADDED_LINE"), HOLOGRAMS_REMOVED_LINE("HOLOGRAMS.REMOVED_LINE"),

    WORLD_DOWNLOAD_NOTIFY("ANTI_WORLD_DOWNLOADER.ADMIN_NOTIFY");

    private static FileConfiguration config;
    private String path;

    Messages(String path) {
        this.path = path;
    }

    protected static void setConfiguration(FileConfiguration c) {
        config = c;
    }

    @Override
    public String toString() {
        String message = config.getString("Messages." + this.path);

        if (message == null || message.isEmpty()) {
            return "DeluxeHub: message not found (" + this.path + ")";
        }

        String prefix = config.getString("Messages." + PREFIX.getPath());
        return TextUtil.color(message.replace("%prefix%", prefix != null && !prefix.isEmpty() ? prefix : ""));
    }

    public String getPath() {
        return this.path;
    }
}
