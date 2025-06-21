package com.programming.systemdesign.lowleveldesign.tictactoe;

public class Player {

    private String name;

    private Symbol symbol;

    // TODO: We can use strategy pattern to use AI player

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
