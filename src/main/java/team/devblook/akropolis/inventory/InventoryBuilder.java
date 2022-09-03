package team.devblook.akropolis.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import team.devblook.akropolis.util.TextUtil;

import java.util.HashMap;
import java.util.Map;

public class InventoryBuilder implements InventoryHolder {
    private final Map<Integer, InventoryItem> icons;
    private int size;
    private final String title;

    public InventoryBuilder(int size, String title) {
        this.icons = new HashMap<>();
        this.size = size;
        this.title = title;
    }

    public void setItem(int slot, InventoryItem item) {
        icons.put(slot, item);
    }

    public InventoryItem getIcon(final int slot) {
        return icons.get(slot);
    }

    @SuppressWarnings("NullableProblems")
    public Inventory getInventory() {
        if (size > 54)
            size = 54;
        else if (size < 9)
            size = 9;

        Inventory inventory = Bukkit.createInventory(this, size, TextUtil.parse(title));
        for (Map.Entry<Integer, InventoryItem> entry : icons.entrySet()) {
            inventory.setItem(entry.getKey(), entry.getValue().getItemStack());
        }
        return inventory;
    }
}