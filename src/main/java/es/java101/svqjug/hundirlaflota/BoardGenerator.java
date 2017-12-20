package es.java101.svqjug.hundirlaflota;

public class BoardGenerator {

    public Board generateNewBoard(){

        Board board = new Board(10);
        Ship ship;

        do {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            ship =  new Ship(x, y);
            if (board.isEmptyCell(x, y)) {
                board.addShip(ship);
            }
        } while (board.getNumberOfShipAlive() != 10);

        return board;
    }
}
