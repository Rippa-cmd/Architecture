package ru.geekbrains.composite.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FilesTree {

    private final File rootFile;

    public FilesTree(Path rootPath) {
        rootFile = new FileImpl(rootPath);
    }

    public void startCreatingTree() {
        createFileTree(rootFile);
        System.out.println(rootFile);
    }

    private void createFileTree(File file) {
        try {
            if (Files.isDirectory(file.getPath())) {
                List<File> nestedFilesList = new ArrayList<>();
                Files.list(file.getPath()).forEach(nestedFilePath -> nestedFilesList.add(new FileImpl(nestedFilePath)));
                file.addNestedFiles(nestedFilesList);
                nestedFilesList.forEach(this::createFileTree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
