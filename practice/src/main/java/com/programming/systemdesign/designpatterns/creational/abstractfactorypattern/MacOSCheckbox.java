package com.programming.systemdesign.designpatterns.creational.abstractfactorypattern;

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paintCheckbox() {
        System.out.println("Painted mac os checkbox");
    }

    @Override
    public void onSelect() {
        System.out.println("Mac OS checkbox selected");
    }
}
