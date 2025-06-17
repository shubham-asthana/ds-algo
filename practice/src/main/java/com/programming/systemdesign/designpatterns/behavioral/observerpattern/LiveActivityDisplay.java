package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

public class LiveActivityDisplay implements FitnessDataObserver {

    @Override
    public void update(FitnessData fitnessData) {
        System.out.println("Live Display: Step -> " + fitnessData.getSteps() + " | Active Minutes -> "
                + fitnessData.getActiveMinutes() + " | Calories Burnt -> " + fitnessData.getCalories());
    }

}
