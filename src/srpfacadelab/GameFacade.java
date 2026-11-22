package srpfacadelab;

public class GameFacade {

    private final SimpleGameEngine gameEngine;
    private final RpgPlayer player;

    public GameFacade() {
        gameEngine = new SimpleGameEngine();
        player = new RpgPlayer(gameEngine);

        gameEngine.addPlayer(player);
    }

    public boolean pickUpItem(Item item) {
        return player.pickUpItem(item);
    }

    public void useItem(Item item) {
        player.useItem(item);
    }

    public void takeDamage(int damage) {
        player.takeDamage(damage);
    }

    public int getHealth() {
        return player.getHealth();
    }

    public void setHealth(int health) {
        player.setHealth(health);
    }

    public void setMaxHealth(int maxHealth) {
        player.setMaxHealth(maxHealth);
    }

    public int getArmour() {
        return player.getArmour();
    }
}