package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

public class GoalNotifier implements FitnessDataObserver {

    private final int stepsGoal = 10000;
    private boolean goalReached;

    @Override
    public void update(FitnessData fitnessData) {
        if (fitnessData.getSteps() >= stepsGoal && !goalReached) {
            System.out.println("You have hit your goal of " + stepsGoal + " steps!!");
            goalReached = true;
        }
    }

    public void reset() {
        goalReached = false;
    }
}
