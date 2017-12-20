package es.java101.svqjug.hundirlaflota;

public class Player {

    private String name;
    private int numberOfPlayer = 0;

    public class generateNewPlayer() {

        BoardGenerator generator = new BoardGenerator();
        Board board = generator.generateNewBoard();

    }

    public Player(String name) {
        this.name = name;
        numberOfPlayer++;
        String playerNumber = "Player " + numberOfPlayer;

    }

      public String getName() {
        return name;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }


}
