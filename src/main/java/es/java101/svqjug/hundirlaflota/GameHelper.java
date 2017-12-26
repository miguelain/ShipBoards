package es.java101.svqjug.hundirlaflota;

import java.util.Scanner;

public class GameHelper {

    public void gameIntro() {

        System.out.println("\t **** Welcome to this.GameOfShips \n\t **** Rules:");
        System.out.printf("\n\t **** In order to start a new Game Of Ships you will need 2 players" +
                "\n\t **** In this ver 2.0 , each player has a random board build with 10 ships" +
                "\n\t **** To Win, be the first to sink every ship on enemy player");
    }

    public void shootIntro() {

        System.out.printf("\n\t **** Make shoots to sink enemy Ships" +
        "\n\t **** A shoot is made by hitting 2 positions" +
        "\n\t *** First a hit for x Axis \u2192 , then a hit for Y Axis \u2193 ");
    }

    public String askForDrawBoard() {

        Scanner scanner = new Scanner(System.in);
        String yesOrNot;
        boolean yesWeDraw;

        do {
            System.out.println("\n\t **** Want to see your enemy Board? (answer y or n)");
            yesOrNot = scanner.nextLine();
            yesWeDraw = checkYesOrNot(yesOrNot);
            if (!yesWeDraw) {
                System.out.println("\n\t **** Please make sure your input is a YES(y) or Not (n), thanks");
            }
        } while (!yesWeDraw);

        return yesOrNot;
    }

    public boolean checkYesOrNot(String yesOrNot) {

        if(yesOrNot.equalsIgnoreCase("y") || (yesOrNot.equalsIgnoreCase("n"))) {
            return true;
        }
        return false;
    }

    public void playerTurn(Player playerTurn, Player enemyPlayer) {

        Board board2 = enemyPlayer.getBoard();
        boolean shootOK;

        do {
            int x = playerTurn.shootAxis("x");
            int y = playerTurn.shootAxis("y");
            shootOK = board2.canFireInCell(x,y);
            if (shootOK) {
                board2.fireInCell(x, y);
            } else {
                System.out.println("This shoot in x: " + x + " y: " + y + " already has been done \n\t Please shoot again...");
            }
        } while (!shootOK);

        if (askForDrawBoard().equalsIgnoreCase("y")) {
            board2.drawBoard(enemyPlayer);
        }

    }

}
