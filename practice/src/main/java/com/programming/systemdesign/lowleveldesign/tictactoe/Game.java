package com.programming.systemdesign.lowleveldesign.tictactoe;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;

    public Game(int size, Player player1, Player player2) {
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
        // TODO: Use a queue for players
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        Player currentPlayer = player1;

        board.printBoard();
        while (true) {

            System.out.println("Make your move " + currentPlayer.getName() + " (Symbol: " + currentPlayer.getSymbol()
                    + ")");
            System.out.println("Enter row: ");
            int row = sc.nextInt();
            System.out.println("Enter col: ");
            int col = sc.nextInt();

            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();

                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println("Player " + currentPlayer.getName() + " wins!!");
                    board.printBoard();
                    break;
                }

                if (board.isFull()) {
                    System.out.println("Its a draw!!");
                    board.printBoard();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
        }
        sc.close();
    }
}
