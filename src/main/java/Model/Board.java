package Model;

public class Board {
    private final int rows;
    private final int cols;
    private Cell[][] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initialize();
    }

    private void initialize() {
        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public void makeMove(int row, int col) {
        for (int r = row; r < rows; r++) {
            for (int c = col; c < cols; c++) {
                cells[r][c].eat();
            }
        }
    }

    public boolean isCellAvailable(int row, int col) {
        return !cells[row][col].isEaten();
    }

    public boolean isPoisonEaten() {
        return cells[0][0].isEaten();
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
