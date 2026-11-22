package srpfacadelab;

public class RpgPlayer {

    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final InventoryManager inventoryManager;
    private final CombatManager combatManager;
    private final ItemManager itemManager;

    private int health;
    private int maxHealth;
    private int armour;

    public RpgPlayer(IGameEngine gameEngine) {
        inventoryManager = new InventoryManager(MAX_CARRYING_CAPACITY);
        combatManager = new CombatManager(gameEngine, inventoryManager);
        itemManager = new ItemManager(gameEngine, inventoryManager);
    }

    public void useItem(Item item) {
        itemManager.useItem(item, this);
    }

    public boolean pickUpItem(Item item) {
        return itemManager.pickUpItem(item, this);
    }

    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void updateStats() {
        armour = 0;

        for (Item item : inventoryManager.getItems()) {
            armour += item.getArmour();
        }
    }

    public void takeDamage(int damage) {
        health -= combatManager.calculateDamageTaken(damage, armour);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    public int getCarryingCapacity() {
        return inventoryManager.getCarryingCapacity();
    }
}