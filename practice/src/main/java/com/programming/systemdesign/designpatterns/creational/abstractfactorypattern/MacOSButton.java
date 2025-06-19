package com.programming.systemdesign.designpatterns.creational.abstractfactorypattern;

public class MacOSButton implements Button {

    @Override
    public void paintButton() {
        System.out.println("Painted mac os button");
    }

    @Override
    public void onClick() {
        System.out.println("Mac OS button clicked");
    }
}
