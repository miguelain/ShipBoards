package es.java101.svqjug.hundirlaflota;

import java.util.Scanner;

public class Player {

    private int numberOfPlayers = 0;
    private String name;
    private String id;
    private Board board;

    public Player() {
        numberOfPlayers++;
        this.name = askNewPlayerName();
        this.id = "Player " + numberOfPlayers;
        this.board = createPlayerBoard();
    }

      public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Board getBoard() {
        return board;
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

    public Board createPlayerBoard() {
        BoardGenerator generator = new BoardGenerator();
        return generator.generateNewBoard();
    }
}