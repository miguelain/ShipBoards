package es.java101.svqjug.hundirlaflota;

import java.util.LinkedList;
import java.util.List;

public class GameController {

    private List<Player> players = new LinkedList<>();
    private List<Board> boards = new LinkedList<>();

    public static void main(String[] args) {

        GameController controller = new GameController();
        GameHelper gameHelper = new GameHelper();
        Player player1, player2;
        Board board1, board2;
        int player1ShipsAlive, player2ShipsAlive;

        gameHelper.gameIntro();
        controller.addPlayer( 0);
        player1 = controller.players.get(0);
        controller.addPlayer(1);
        player2 = controller.players.get(1);

        System.out.println("\n\t **** " + player1.getName() + " Vs " + player2.getName() + " ****");
        System.out.println("\n\t *************** F I G H T ***************");

        gameHelper.shootIntro();

        do {
            gameHelper.playerTurn(player1, player2);
            gameHelper.playerTurn(player2, player1);
            player1ShipsAlive = player1.getBoard().getNumberOfShipAlive();
            player2ShipsAlive = player2.getBoard().getNumberOfShipAlive();

        } while ((player1ShipsAlive != 0) || (player2ShipsAlive != 0));

        // show results
    }

    public void addPlayer(int x) {
        players.add(new Player());
        boards.add(players.get(x).getBoard());
    }

}
