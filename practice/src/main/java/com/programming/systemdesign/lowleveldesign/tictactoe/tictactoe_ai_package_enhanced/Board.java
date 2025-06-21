package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

public class Board {
    private final char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    public int getSize() {
        return board.length;
    }

    public void makeMove(int row, int col, Symbol symbol) throws Exception {
        if (validMove(row, col)) {
            board[row][col] = symbol.name().charAt(0);
        } else {
            throw new Exception("Invalid move");
        }
    }

    public void undoMove(int row, int col) {
        board[row][col] = '-';
    }

    private boolean validMove(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == '-';
    }

    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-')
                    return false;
            }
        }
        return true;
    }

    public boolean checkWin(Symbol symbol) {
        char ch = symbol.name().charAt(0);
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (allEqual(ch, board[i]))
                return true;
            boolean colMatch = true;
            for (int j = 0; j < n; j++) {
                if (board[j][i] != ch)
                    colMatch = false;
            }
            if (colMatch)
                return true;
        }

        boolean mainDiagonal = true, antiDiagonal = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != ch)
                mainDiagonal = false;
            if (board[i][n - 1 - i] != ch)
                antiDiagonal = false;
        }
        return mainDiagonal || antiDiagonal;
    }

    private boolean allEqual(char ch, char[] row) {
        for (char c : row)
            if (c != ch)
                return false;
        return true;
    }
}