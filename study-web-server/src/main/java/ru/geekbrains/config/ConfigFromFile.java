package ru.geekbrains.config;

import java.io.IOException;
import java.util.Properties;

class ConfigFromFile implements Config{

    private final int PORT;

    private final int THREADS;

    private final String WWW;

    public ConfigFromFile(String fileName) {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        this.PORT = Integer.parseInt(prop.getProperty("port"));
        this.THREADS = Integer.parseInt(prop.getProperty("threads"));
        this.WWW = prop.getProperty("www.home");
    }

    @Override
    public int getPort() {
        return PORT;
    }

    @Override
    public int getThreads() {
        return THREADS;
    }

    @Override
    public String getWWW() {
        return WWW;
    }
}
