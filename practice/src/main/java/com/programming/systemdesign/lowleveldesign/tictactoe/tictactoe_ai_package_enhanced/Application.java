package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

public class Application {
    public static void main(String[] args) {
        Player p1 = new Player("Human", Symbol.X, new HumanMoveStrategy());
        Player p2 = new Player("AI", Symbol.O, new RandomAIMoveStrategy());

        Game game = new Game(p1, p2, 3);
        game.start();
    }
}