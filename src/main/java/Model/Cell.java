package Model;

public class Cell {
    private boolean eaten;

    public Cell() {
        this.eaten = false;
    }

    public void eat() {
        this.eaten = true;
    }

    public boolean isEaten() {
        return eaten;
    }
}
