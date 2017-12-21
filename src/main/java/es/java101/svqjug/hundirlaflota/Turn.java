package es.java101.svqjug.hundirlaflota;

import java.util.Scanner;

public class Turn {
    private String player;

    public Turn(String player) {
        this.player = player;
    }

    public int shootAxis(String axis) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t *** Player " + player + axis + "axis shoot: ***");
        int x = scanner.nextInt();

        return x;
    }
}
