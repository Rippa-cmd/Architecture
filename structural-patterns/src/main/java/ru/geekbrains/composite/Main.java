package ru.geekbrains.composite;

import ru.geekbrains.composite.files.FilesTree;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        FilesTree filesTree = new FilesTree(Paths.get("C:\\Users\\Sovereign"));
        filesTree.startCreatingTree();
    }
}
