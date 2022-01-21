package ru.geekbrains.composite.files;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileImpl implements File{
    private final Path path;

    private final String name;

    private final List<File> nestedFiles = new ArrayList<>();

    public FileImpl(Path path) {
        this.path = path;
        this.name = path.getFileName().toString();
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public List<File> getNestedFiles() {
        return nestedFiles;
    }

    public void addNestedFile(File file) {
        nestedFiles.add(file);
    }

    @Override
    public void addNestedFiles(List<File> files) {
        nestedFiles.addAll(files);
    }
}
