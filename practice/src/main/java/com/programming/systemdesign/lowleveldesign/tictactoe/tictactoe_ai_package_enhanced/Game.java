package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

import java.util.*;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Stack<MoveRecord> history;
    private final List<MoveRecord> replay;

    public Game(Player p1, Player p2, int boardSize) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<>();
        this.history = new Stack<>();
        this.replay = new ArrayList<>();
        players.offer(p1);
        players.offer(p2);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            Player current = players.poll();
            System.out.println(current.getName() + "'s turn (" + current.getSymbol() + ")");
            System.out.print("Enter 'u' to undo, 'r' to replay, or any key to continue: ");
            String input = scanner.nextLine();

            if (input.equals("u")) {
                undoMove();
                players.offer(current);
                continue;
            } else if (input.equals("r")) {
                replayGame();
                players.offer(current);
                continue;
            }

            int[] move = current.makeMove(board);

            try {
                board.makeMove(move[0], move[1], current.getSymbol());
                MoveRecord record = new MoveRecord(current, move[0], move[1]);
                history.push(record);
                replay.add(record);
                if (board.checkWin(current.getSymbol())) {
                    board.printBoard();
                    System.out.println(current.getName() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid move. Try again.");
                players.offer(current);
                continue;
            }
            players.offer(current);
        }
    }

    private void undoMove() {
        if (!history.isEmpty()) {
            MoveRecord lastMove = history.pop();
            board.undoMove(lastMove.getRow(), lastMove.getCol());
            System.out.println("Undid move at (" + lastMove.getRow() + ", " + lastMove.getCol() + ")");
        } else {
            System.out.println("No moves to undo.");
        }
    }

    private void replayGame() {
        Board tempBoard = new Board(board.getSize());
        System.out.println("Replaying game:");
        for (MoveRecord move : replay) {
            try {
                tempBoard.makeMove(move.getRow(), move.getCol(), move.getPlayer().getSymbol());
                tempBoard.printBoard();
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class MoveRecord {
        private final Player player;
        private final int row, col;

        public MoveRecord(Player player, int row, int col) {
            this.player = player;
            this.row = row;
            this.col = col;
        }

        public Player getPlayer() {
            return player;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}