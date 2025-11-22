package Model;

/**
 * The type Player. Represent a player in the Chomp game.
 *
 * Stores player name, which is used for turn tracking and winner determination.
 */
public class Player {
    private final String name;

    /**
     * Instantiates a new Player.
     *
     * @param name the name to identify a player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the name of this player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
}
