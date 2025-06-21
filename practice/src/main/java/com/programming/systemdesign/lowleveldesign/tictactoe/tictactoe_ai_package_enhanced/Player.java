package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

public class Player {
    private final String name;
    private final Symbol symbol;
    private final MoveStrategy strategy;

    public Player(String name, Symbol symbol, MoveStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int[] makeMove(Board board) {
        return strategy.getMove(board);
    }
}