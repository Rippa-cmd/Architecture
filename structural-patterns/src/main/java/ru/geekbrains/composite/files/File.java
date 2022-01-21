package ru.geekbrains.composite.files;

import java.nio.file.Path;
import java.util.List;

public interface File {
    String getName();
    Path getPath();
    void addNestedFile(File file);
    void addNestedFiles(List<File> files);
}
