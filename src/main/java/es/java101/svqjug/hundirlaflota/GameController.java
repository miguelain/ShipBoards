package es.java101.svqjug.hundirlaflota;

import java.util.LinkedList;
import java.util.List;

public class GameController {
    private List<Player> players = new LinkedList<>();
    private List<Board> boards = new LinkedList<>();

    public static void main(String[] args) {

        GameController controller = new GameController();

        controller.gameIntro();
        controller.addPlayer( 0);
        controller.addPlayer(1);

        System.out.println("\n\t **** " + controller.players.get(0).getName() + " Vs " + controller.players.get(1).getName() + " ****");
        System.out.println("\n\t *************** F I G H T ***************");

        controller.shootIntro();

        controller.startGame();

        // show results
    }

    public void gameIntro() {
        System.out.println("\t **** Welcome to this.GameOfShips \n\t **** Rules:");
        System.out.printf("\n\t **** In order to start a new Game Of Ships you will need 2 players" +
                "\n\t **** In this ver 2.0 , each player has a random board build with 10 ships" +
                "\n\t **** To Win, be the first to sink every ship on enemy player");
    }

    public void shootIntro() {
        System.out.println("\n\t **** Make shoots to sink enemy Ships");
        System.out.println("\n\t **** A shoot is made by hitting 2 positions");
        System.out.println("\n\t *** First a hit for x Axis \u2192 , then a hit for Y Axis \u2193 ");
    }

    public void addPlayer(int x) {
        players.add(new Player());
        boards.add(players.get(x).getBoard());
    }

    private void startGame() {

        int x = players.get(0).shootAxis("x");
        int y = players.get(0).shootAxis("y");
        if (players.get(0).getBoard().canFireInCell(x, y)) {
            players.get(0).getBoard().fireInCell(x,y);
        }
    }
}
