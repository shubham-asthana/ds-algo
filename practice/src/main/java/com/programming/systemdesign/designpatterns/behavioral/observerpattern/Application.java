package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

public class Application {

    public static void main(String[] args) {

        FitnessData fitnessData = new FitnessData();

        LiveActivityDisplay liveActivityDisplay = new LiveActivityDisplay();
        ProgressLogger progressLogger = new ProgressLogger();
        GoalNotifier goalNotifier = new GoalNotifier();

        fitnessData.registerObserver(liveActivityDisplay);
        fitnessData.registerObserver(progressLogger);
        fitnessData.registerObserver(goalNotifier);

        fitnessData.newDataPushed(100, 30, 50);
        fitnessData.newDataPushed(9800, 90, 200);
        fitnessData.newDataPushed(10100, 105, 250);

        goalNotifier.reset();
        fitnessData.dailyReset();
    }
}
