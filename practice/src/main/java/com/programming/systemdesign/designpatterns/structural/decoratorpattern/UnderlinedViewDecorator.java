package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public class UnderlinedViewDecorator extends TextDecorator {

    public UnderlinedViewDecorator(TextView textView) {
        super(textView);
    }

    @Override
    public void render() {
        System.out.print("<u>");
        textView.render();
        System.out.print("</u>");
    }
}
