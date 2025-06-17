package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

public class ProgressLogger implements FitnessDataObserver {

    @Override
    public void update(FitnessData fitnessData) {
        System.out
                .println("Saving the fitness data to file: Step -> " + fitnessData.getSteps() + " | Active Minutes -> "
                        + fitnessData.getActiveMinutes() + " | Calories Burnt -> " + fitnessData.getCalories());
    }

}
