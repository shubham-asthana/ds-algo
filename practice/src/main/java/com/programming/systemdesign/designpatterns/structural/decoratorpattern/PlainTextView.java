package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public class PlainTextView implements TextView {

    private String text;

    public PlainTextView(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.print(text);
    }
}
