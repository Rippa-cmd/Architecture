package ru.geekbrains.state;

import ru.geekbrains.state.states.DefaultText;
import ru.geekbrains.state.states.LowerCase;
import ru.geekbrains.state.states.TextEditor;
import ru.geekbrains.state.states.UpperCase;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(new DefaultText());

        textEditor.type("First line");

        textEditor.setState(new UpperCase());

        textEditor.type("Second line");
        textEditor.type("Third line");

        textEditor.setState(new LowerCase());

        textEditor.type("Fourth line");
        textEditor.type("Fifth line");
    }
}
