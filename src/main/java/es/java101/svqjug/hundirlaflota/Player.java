package es.java101.svqjug.hundirlaflota;

import java.util.Scanner;

public class Player {

    private int numberOfPlayers = 0;
    private String name;
    private String id;

    public class generateNewPlayer() {

        BoardGenerator generator = new BoardGenerator();
        Board board = generator.generateNewBoard();

    }

    public Player() {
        numberOfPlayers++;
        this.name = askNewPlayerName();
        this.id = "Player " + numberOfPlayers;

    }

      public String getName() {
        return name;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayers;
    }

    public String askNewPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\t **** Player " + numberOfPlayers + " name: ...");
        String name = scanner.nextLine();

        return name;
    }

}
