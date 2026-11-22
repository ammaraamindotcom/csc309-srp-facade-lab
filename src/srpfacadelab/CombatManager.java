package srpfacadelab;

public class CombatManager {
    private final IGameEngine gameEngine;
    private final InventoryManager inventoryManager;

    public CombatManager(IGameEngine gameEngine,
                         InventoryManager inventoryManager) {
        this.gameEngine = gameEngine;
        this.inventoryManager = inventoryManager;
    }

    public int calculateDamageTaken(int damage, int armour) {
        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - armour;

        if (inventoryManager.getTotalWeight()
                < inventoryManager.getCarryingCapacity() * 0.5) {
            damageToDeal = (int) (damageToDeal * 0.75);
        }

        gameEngine.playSpecialEffect("lots_of_gore");
        return damageToDeal;
    }
}