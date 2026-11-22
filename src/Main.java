import srpfacadelab.GameFacade;
import srpfacadelab.Item;

public class Main {

    public static void main(String[] args) {

        GameFacade game = new GameFacade();

        game.setMaxHealth(100);
        game.setHealth(100);

       Item sword = new Item(1, "Sword", 0, 20, 100, true, true);

        game.pickUpItem(sword);

        game.takeDamage(50);

        System.out.println("Player health: " + game.getHealth());
    }
}