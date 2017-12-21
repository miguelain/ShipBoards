package es.java101.svqjug.hundirlaflota;

public class GameController {

    public static void main(String[] args) {

       GameController controller = new GameController();

       controller.gameIntro();

        Player player1 = Player.generatePlayer(String name);

        create player 2, create board 2

        start game

        show results
    }

    public void gameIntro() {
        System.out.println("\t **** Welcome to this.GameOfShips \n\t **** Rules:");
        System.out.printf("\n\t **** In order to start a new Game Of Ships you will need 2 players" +
                "\n\t **** In this ver 2.0 , each player has a random board build with 10 ships" +
                "\n\t **** To Win, be the first to sink every ship on enemy player");
    }

}
