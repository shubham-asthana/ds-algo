package com.programming.systemdesign.designpatterns.behavioral.observerpattern;

public interface FitnessDataObservable {

    void registerObserver(FitnessDataObserver fitnessDataObserver);

    void removeObserver(FitnessDataObserver fitnessDataObserver);

    void notifyObservers();
}
