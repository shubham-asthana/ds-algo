package com.programming.systemdesign.lowleveldesign.tictactoe.tictactoe_ai_package_enhanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAIMoveStrategy implements MoveStrategy {
    private final Random random = new Random();

    @Override
    public int[] getMove(Board board) {
        List<int[]> available = new ArrayList<>();
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isCellEmpty(i, j)) {
                    available.add(new int[] { i, j });
                }
            }
        }
        return available.get(random.nextInt(available.size()));
    }
}