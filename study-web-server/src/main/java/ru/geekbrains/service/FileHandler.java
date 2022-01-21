package ru.geekbrains.service;

import ru.geekbrains.config.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    private final Config config;

    private final String filePath;

    private Path path;

    private FileHandler(Config config, String filePath) {
        this.config = config;
        this.filePath = filePath;
        path = Paths.get(config.getWWW(), filePath);
    }

    public static FileHandler createFileHandler(Config config, String filePath) {
        return new FileHandler(config, filePath);
    }

    public boolean isFileUnreadable() {
        return !Files.exists(path) || Files.isDirectory(path);
    }

    public String readFile() {
        StringBuilder body = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(body::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }
}
