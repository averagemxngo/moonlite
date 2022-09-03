package team.devblook.akropolis.hook.hooks.head;

import com.cryptomorin.xseries.XMaterial;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import team.devblook.akropolis.AkropolisPlugin;
import team.devblook.akropolis.hook.PluginHook;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BaseHead implements PluginHook, HeadHook {
    private AkropolisPlugin plugin;
    private Map<String, ItemStack> cache;

    @Override
    public void onEnable(AkropolisPlugin plugin) {
        this.plugin = plugin;
        cache = new HashMap<>();
    }

    @Override
    public ItemStack getHead(String data) {
        if (cache.containsKey(data)) return cache.get(data);

        ItemStack head = XMaterial.PLAYER_HEAD.parseItem();

        if (head == null) {
            plugin.getLogger().severe("Could not parse head!");
            return XMaterial.SKELETON_SKULL.parseItem();
        }

        SkullMeta meta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");

        profile.getProperties().put("textures", new Property("textures", data));
        Field profileField;

        try {
            if (meta == null) {
                plugin.getLogger().severe("Could not parse head meta!");
                return head;
            }

            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        head.setItemMeta(meta);
        cache.put(data, head);
        return head;
    }
}