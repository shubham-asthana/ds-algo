package com.programming.systemdesign.designpatterns.structural.decoratorpattern;

public class Application {

    public static void main(String[] args) {
        TextView textView = new PlainTextView("Hello World!!");

        System.out.print("Plain Text View: ");
        textView.render();

        System.out.println();
        System.out.print("Bold Text View: ");
        TextDecorator boldViewDecorator = new BoldViewDecorator(textView);
        boldViewDecorator.render();

        System.out.println();
        System.out.print("Bold + Italics Text View: ");
        TextDecorator italicsViewDecorator = new ItalicsVIewDecorator(boldViewDecorator);
        italicsViewDecorator.render();

        System.out.println();
        System.out.print("Bold + Italics + Underlined Text View: ");
        TextDecorator underlinedTextDecorator = new UnderlinedViewDecorator(italicsViewDecorator);
        underlinedTextDecorator.render();
    }
}
