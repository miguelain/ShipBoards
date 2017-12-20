package es.java101.svqjug.hundirlaflota;

public class Ship {

    private int x;
    private int y;
    private boolean alive = true;

    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getAlive() {
        return alive;
    }

    public void sinkShip() {
        alive = false;
    }
}
