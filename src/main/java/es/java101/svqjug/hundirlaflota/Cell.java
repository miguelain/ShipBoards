package es.java101.svqjug.hundirlaflota;

public class Cell {
    private int x;
    private int y;
    private boolean used = false;


    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getUsed() {
        return used;
    }

    public boolean usedCell() {
        used = true;
        return used;
    }
}