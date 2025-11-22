package Model;

/**
 * The type Board.  A 2D grid of Cell objects that represents the Chomp game's chocolate bar.
 *
 * Implements the Chomp game logic for eating squares and checking game state.
 */
public class Board {
    private final int rows;
    private final int cols;

    // 2D array representing the chocolate bar
    private Cell[][] cells;

    /**
     * Instantiates a new Board with all cells uneaten.
     *
     * @param rows the number of rows in the chocolate bar
     * @param cols the number of cols in the chocolate bar
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initialize();
    }

    /**
     * Initializes the board with uneaten cells.
     *
     * Create individual cell objects for each position on the grid.
     */
    private void initialize() {
        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    /**
     * Resets the board to initial state with all cells uneaten. (not in architecture)
     *
     * Start a new game through the reset button --> without creating a new Board instance.
     */
    public void reset() {
        initialize();
    }

    /**
     * Make a move at the specified position.
     *
     * Mark the selected cell and all cells to the right and above as eaten.
     *
     * @param row the row idx of selected cell
     * @param col the col idx of selected cell
     */
    public void makeMove(int row, int col) {
        for (int r = row; r < rows; r++) {
            for (int c = col; c < cols; c++) {
                cells[r][c].eat();
            }
        }
    }

    /**
     * Check if cell is not eaten.
     *
     * @param row the row idx to check
     * @param col the col idx to check
     * @return true if cell is available, false if eaten
     */
    public boolean isCellAvailable(int row, int col) {
        return !cells[row][col].isEaten();
    }

    /**
     * Check if the poison cell is eaten to end game.
     *
     * @return true if poison cell is eaten, false otherwise
     */
    public boolean isPoisonEaten() {
        return cells[0][0].isEaten();
    }

    /**
     * Getter for cell object at specified position.
     *
     * @param row the row idx to retrieve
     * @param col the col idx to retrieve
     * @return the cell
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Gets rows of board.
     *
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets cols of board.
     *
     * @return the number of cols
     */
    public int getCols() {
        return cols;
    }
}
