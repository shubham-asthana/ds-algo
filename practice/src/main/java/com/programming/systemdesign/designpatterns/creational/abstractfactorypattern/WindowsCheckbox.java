package com.programming.systemdesign.designpatterns.creational.abstractfactorypattern;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paintCheckbox() {
        System.out.println("Painted windows checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Windows checkbox selected");
    }
}
