package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public abstract class TextDecorator implements TextView {

    protected final TextView textView;

    public TextDecorator(TextView textView) {
        this.textView = textView;
    }
}
