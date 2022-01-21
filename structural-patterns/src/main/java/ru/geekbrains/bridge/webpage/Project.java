package ru.geekbrains.bridge.webpage;

import ru.geekbrains.bridge.theme.Theme;

public class Project implements WebPage{
    private final Theme theme;

    public Project(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.printf("Project page in %s color%n", theme.getColor());
    }
}
