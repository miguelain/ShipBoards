package es.java101.svqjug.hundirlaflota;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameController {
    private List<Player> players = new LinkedList<>();
    private List<Board> boards = new LinkedList<>();

    public static void main(String[] args) {


        GameController controller = new GameController();



       controller.gameIntro();
       controller.addPlayer();
       controller.addPlayer();

        start game

        show results
    }

    public void gameIntro() {
        System.out.println("\t **** Welcome to this.GameOfShips \n\t **** Rules:");
        System.out.printf("\n\t **** In order to start a new Game Of Ships you will need 2 players" +
                "\n\t **** In this ver 2.0 , each player has a random board build with 10 ships" +
                "\n\t **** To Win, be the first to sink every ship on enemy player");
    }

    public void addPlayer() {
        players.add(new Player());
        // pick last player object from list players, get his board and add it to boards list
        int x = players.lastIndexOf(players);
        Board oneboard = players.get(x).getBoard();
        boards.add(oneboard);
    }
}
