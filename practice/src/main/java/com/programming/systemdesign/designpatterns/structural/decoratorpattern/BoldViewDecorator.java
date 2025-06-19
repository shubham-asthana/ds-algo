package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public class BoldViewDecorator extends TextDecorator {

    public BoldViewDecorator(TextView textView) {
        super(textView);
    }

    @Override
    public void render() {
        System.out.print("<b>");
        textView.render();
        System.out.print("</b>");
    }
}
