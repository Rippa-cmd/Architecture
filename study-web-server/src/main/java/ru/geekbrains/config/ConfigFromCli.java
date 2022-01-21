package ru.geekbrains.config;

class ConfigFromCli implements Config{

    private final int PORT;

    private final int THREADS;

    private final String WWW;

    public ConfigFromCli(String[] args) {
        if (args.length >= 3) {
            this.PORT = Integer.parseInt(args[0]);
            this.THREADS = Integer.parseInt(args[1]);
            this.WWW = args[2];
        } else {
            throw new IllegalArgumentException("Wrong arguments");
        }
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
