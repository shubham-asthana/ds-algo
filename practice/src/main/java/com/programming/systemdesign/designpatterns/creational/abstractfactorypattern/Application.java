package com.programming.systemdesign.designpatterns.creational.abstractfactorypattern;

public class Application {

    private final Button button;

    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.paintButton();
        checkbox.paintCheckbox();
    }
}
