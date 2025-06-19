package com.programming.systemdesign.designpatterns.creational.abstractfactorypattern;

public class WindowsButton implements Button {

    @Override
    public void paintButton() {
        System.out.println("Painted windows button");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button clicked");
    }
}
