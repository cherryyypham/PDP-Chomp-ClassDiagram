import Controller.CHOMPGame;

/**
 * The type Driver. Represents the entry point for the Chomp application.
 */
public class Driver {
    /**
     * Main method to launch the game.
     *
     * @param args the input arguments for cmd line (not used)
     */
    public static void main(String[] args) {
        // Configures board dimensions and players' names. Then, starts the game.
        // Modify this info to customize game
        new CHOMPGame(6, 8, "P1", "P2");
    }
}
