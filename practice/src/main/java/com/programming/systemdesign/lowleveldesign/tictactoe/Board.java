package com.programming.systemdesign.lowleveldesign.tictactoe;

public class Board {

    private Cell[][] cell;

    public Board(int size) {
        this.cell = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                cell[i][j] = new Cell();
            }
        }
    }

    /**
     * Prints the board
     */
    public void printBoard() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                System.out.print(cell[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int row, int col, Symbol symbol) throws Exception {
        if (isValidMove(row, col))
            cell[row][col].setSymbol(symbol);
        else {
            throw new Exception("Invalid move");
        }
    }

    public boolean checkWin(Symbol symbol) {
        for (int i = 0; i < cell.length; i++) {
            if (checkRow(i, symbol) || checkCol(i, symbol))
                return true;
        }
        return checkDiagonal(symbol) || checkAntiDiagonal(symbol);
    }

    public boolean isFull() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                if (cell[i][j].getSymbol().equals(Symbol.EMPTY))
                    return false;
            }
        }
        return true;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < cell.length && col >= 0 && col < cell.length
                && cell[row][col].getSymbol().equals(Symbol.EMPTY);
    }

    private boolean checkRow(int row, Symbol symbol) {
        for (int i = 0; i < cell.length; i++) {
            if (!cell[row][i].getSymbol().equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkCol(int col, Symbol symbol) {
        for (int i = 0; i < cell.length; i++) {
            if (!cell[i][col].getSymbol().equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkDiagonal(Symbol symbol) {
        for (int i = 0; i < cell.length; i++) {
            if (!cell[i][i].getSymbol().equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(Symbol symbol) {
        for (int i = 0; i < cell.length; i++) {
            if (!cell[i][cell.length - 1 - i].getSymbol().equals(symbol))
                return false;
        }
        return true;
    }
}
