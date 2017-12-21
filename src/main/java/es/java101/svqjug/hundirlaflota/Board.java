package es.java101.svqjug.hundirlaflota;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private List<Ship> ships = new LinkedList<>();
    private List<Cell> cells = new LinkedList<>();
    private int size;

    public Board(int size){
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public void addShip(Ship ship){
        if (isEmptyCell(ship.getX(), ship.getY())) {
            ships.add(ship);
        }
    }

    public boolean isEmptyCell(int x, int y){

        for (Ship ship : ships) {
            if(ship.getX() == x && ship.getY() == y){
                return false;
            }
        }
        return true;
    }

    public int getNumberOfShip() {
        return ships.size();
    }

    public boolean canFireInCell(int x, int y){

        if (cells.isEmpty()) {
            return true;
        } else {
            for (Cell cell : cells) {
                if ((cell.getX() == x && cell.getY() == y) && !cell.getUsed()) {
                    return true;
                }
            }
        }

        for (Ship ship : ships) {
            if ((ship.getX() == x && ship.getY() == y) && (ship.getAlive())){
                return true;
            }
        }
        return false;
    }

    public void fireInCell(int x, int y){

        Cell cell = new Cell(x,y);
        cell.usedCell();
        cells.add(cell);

        for (Ship ship : ships) {
            if (ship.getX() == x && ship.getY() == y) {
                ship.sinkShip();
                System.out.println("Barco Hundido");
            }
        }
    }

    public int getNumberOfShipAlive(){
        int numberOfShipsAlive = 0;

        for (Ship ship : ships) {
            if (ship.getAlive()) {
                numberOfShipsAlive++;
            }
        }
            return numberOfShipsAlive;   // why not return ships.size(); , like getNumberOfShip() ?
    }

    public void drawBoard(Player enemyPlayer) {

        Board enemyBoard = enemyPlayer.getBoard();

        for (int i = 0; i < enemyBoard.size; i++) {
            for (int j = 0; j < enemyBoard.size; j++) {
                if (canFireInCell(i,j)) {
                    System.out.println("   ");
                } else {
                    for (Ship ship : ships) {
                        if ((ship.getX() == i && ship.getY() == j) && (!ship.getAlive())){
                            System.out.println(" X ");
                        } else {
                            System.out.println(" * ");
                        }
                    }
                }
            }
        }
    }

}
