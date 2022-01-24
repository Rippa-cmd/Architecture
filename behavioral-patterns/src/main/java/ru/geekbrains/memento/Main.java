package ru.geekbrains.memento;


public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("First one.");
        editor.type("Second one.");

        EditorMemento memento = editor.save();
        System.out.println(editor.getContent());

        editor.type("Third one.");
        System.out.println(editor.getContent());

        editor.restore(memento);
        System.out.println(editor.getContent());
    }
}
