package ru.geekbrains.memento;

public class EditorMemento {
    private final String content;

    EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
