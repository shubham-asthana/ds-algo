package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int[] getMove(Board board) {
        System.out.print("Enter row: ");
        int row = scanner.nextInt();
        System.out.print("Enter col: ");
        int col = scanner.nextInt();
        return new int[] { row, col };
    }
}