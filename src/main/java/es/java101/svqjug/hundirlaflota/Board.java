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

        boolean itsFree = true;

        for (Ship ship : ships) {
            if ((ship.getX() == x && ship.getY() == y) && !ship.getAlive()){
                itsFree = false;
            }
        }

        if (itsFree) {
            for (Cell cell : cells) {
                if ((cell.getX() == x && cell.getY() == y) && cell.getUsed()) {
                    itsFree = false;
                }
            }
        }
        return itsFree;
    }

    public void fireInCell(int x, int y){

        Cell cell = new Cell(x,y);
        cell.usedCell();
        cells.add(cell);
        boolean hitShip = false;

        for (Ship ship : ships) {
            if (ship.getX() == x && ship.getY() == y) {
                ship.sinkShip();
                System.out.println(" * * * * K A B O O O M ! ! ! Ship Destroyed !");
                hitShip = true;
            }
        }
        if (!hitShip) {
            System.out.println("No enemy found there captain, miss shoot");
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

    public void drawBoard(Player enemyPlayer) { // need repair

        Board enemyBoard = enemyPlayer.getBoard();
        boolean printOK;

        System.out.print("    0  1  2  3  4  5  6  7  8  9 ");
        for (int i = 0; i < enemyBoard.size; i++) {
            System.out.println();
            System.out.print(" " + i + " ");
            for (int j = 0; j < enemyBoard.size; j++) {
                printOK = false;

                for (Ship ship : enemyBoard.ships) {
                    if ((ship.getX() == i && ship.getY() == j) && !ship.getAlive()) {
                        System.out.print(" X ");
                        printOK = true;
                        break;
                    }
                }

                if (!printOK) {
                    for (Cell cell : enemyBoard.cells) {
                        if ((cell.getX() == i && cell.getY() == j) && cell.getUsed()) {
                            System.out.print(" * ");
                            printOK = true;
                            break;
                        }
                    }

                    if (!printOK) {
                        System.out.print("   ");
                    }
                }

            } // end for j
        } // end for i

        System.out.println();
    }

}
