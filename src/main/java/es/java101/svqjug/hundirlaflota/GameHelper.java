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

        System.out.println("\n\t **** Make shoots to sink enemy Ships");
        System.out.println("\n\t **** A shoot is made by hitting 2 positions");
        System.out.println("\n\t *** First a hit for x Axis \u2192 , then a hit for Y Axis \u2193 ");
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

    public void startGame(Player player1, Player player2) {

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        int x = player1.shootAxis("x");
        int y = player1.shootAxis("y");
        if (board1.canFireInCell(x, y)) {
            board1.fireInCell(x,y);
        }
        if (askForDrawBoard().equalsIgnoreCase("y")) {
            board2.drawBoard(player2);
        }
    }

}
