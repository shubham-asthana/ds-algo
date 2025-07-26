package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public class ItalicsViewDecorator extends TextDecorator {

    public ItalicsViewDecorator(TextView textView) {
        super(textView);
    }

    @Override
    public void render() {
        System.out.print("<i>");
        textView.render();
        System.out.print("</i>");
    }
}
