package ru.geekbrains.bridge.webpage;

import ru.geekbrains.bridge.theme.Theme;

public class About implements WebPage{
    private final Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void getContent() {
        System.out.printf("About in %s color%n", theme.getColor());
    }
}
