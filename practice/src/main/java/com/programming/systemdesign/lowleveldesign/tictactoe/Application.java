package com.programming.systemdesign.lowleveldesign.tictactoe;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board: ");
        int size = sc.nextInt();

        System.out.println("Enter the player 1 name: ");
        String name1 = sc.next();
        Player player1 = new Player(name1, Symbol.X);

        System.out.println("Enter the player 2 name: ");
        String name2 = sc.next();
        Player player2 = new Player(name2, Symbol.O);

        Game game = new Game(size, player1, player2);
        game.play();

        sc.close();
    }
}
