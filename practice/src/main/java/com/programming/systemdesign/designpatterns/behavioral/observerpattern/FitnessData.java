package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class FitnessData implements FitnessDataObservable {

    private int steps;
    private int activeMinutes;
    private int calories;

    private final List<FitnessDataObserver> fitnessDataObservers = new ArrayList<>();

    @Override
    public void registerObserver(FitnessDataObserver fitnessDataObserver) {
        fitnessDataObservers.add(fitnessDataObserver);
    }

    @Override
    public void removeObserver(FitnessDataObserver fitnessDataObserver) {
        fitnessDataObservers.remove(fitnessDataObserver);
    }

    @Override
    public void notifyObservers() {
        for (FitnessDataObserver fitnessDataObserver : fitnessDataObservers) {
            fitnessDataObserver.update(this);
        }
    }

    public void newDataPushed(int steps, int minutes, int calories) {
        this.steps = steps;
        this.activeMinutes = minutes;
        this.calories = calories;
        System.out.println("New Fitness Data Pushed");

        notifyObservers();
    }

    public void dailyReset() {
        this.steps = 0;
        this.activeMinutes = 0;
        this.calories = 0;
        System.out.println("Daily reset performed");

        notifyObservers();
    }

    public int getSteps() {
        return steps;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public int getCalories() {
        return calories;
    }
}
