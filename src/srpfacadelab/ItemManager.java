package srpfacadelab;

import java.util.List;

public class ItemManager {
    private final IGameEngine gameEngine;
    private final InventoryManager inventoryManager;

    public ItemManager(IGameEngine gameEngine,
                       InventoryManager inventoryManager) {
        this.gameEngine = gameEngine;
        this.inventoryManager = inventoryManager;
    }

    public boolean pickUpItem(Item item, RpgPlayer player) {
        if (!inventoryManager.canCarry(item)) {
            return false;
        }

        if (item.isUnique() && inventoryManager.containsUniqueItem(item)) {
            return false;
        }

        if (item.getHeal() > 0) {
            player.heal(item.getHeal());

            if (item.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }
            return true;
        }

        if (item.isRare()) {
            gameEngine.playSpecialEffect("cool_swirly_particles");
        }

        if (item.isRare() && item.isUnique()) {
            gameEngine.playSpecialEffect("blue_swirly");
        }

        inventoryManager.addItem(item);
        player.updateStats();
        return true;
    }

    public void useItem(Item item, RpgPlayer player) {
        if (item.getName().equals("Stink Bomb")) {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(player);

            if (enemies != null) {
                for (IEnemy enemy : enemies) {
                    enemy.takeDamage(100);
                }
            }
        }
    }
}