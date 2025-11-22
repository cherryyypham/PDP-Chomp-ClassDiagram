package Model;

/**
 * The type Cell.   Represents a single chocolate square in the Chomp game.
 *
 * Tracks whether the cell has been eaten or remains available.
 */
public class Cell {
    // Boolean flag indicating if this cell has been eaten
    private boolean eaten;

    /**
     * Instantiates a new Cell.
     *
     * All cells start as uneaten.
     */
    public Cell() {
        this.eaten = false;
    }

    /**
     * Marks a cell as eaten.
     *
     * Once eaten, a cell cannot be selected again.
     */
    public void eat() {
        this.eaten = true;
    }

    /**
     * Checks if the cell has been eaten
     *
     * @return true if cell has been eaten, false if cell still active
     */
    public boolean isEaten() {
        return eaten;
    }
}
