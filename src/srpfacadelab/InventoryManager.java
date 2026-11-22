package srpfacadelab;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private final List<Item> inventory;
    private final int carryingCapacity;

    public InventoryManager(int carryingCapacity) {
        this.inventory = new ArrayList<>();
        this.carryingCapacity = carryingCapacity;
    }

    public boolean canCarry(Item item) {
        return getTotalWeight() + item.getWeight() <= carryingCapacity;
    }

    public boolean containsUniqueItem(Item item) {
        for (Item existing : inventory) {
            if (existing.getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public int getTotalWeight() {
        int total = 0;

        for (Item item : inventory) {
            total += item.getWeight();
        }

        return total;
    }

    public List<Item> getItems() {
        return new ArrayList<>(inventory);
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }
}
