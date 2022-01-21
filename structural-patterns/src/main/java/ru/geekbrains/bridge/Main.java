package ru.geekbrains.bridge;

import ru.geekbrains.bridge.theme.AquaTheme;
import ru.geekbrains.bridge.theme.DarkTheme;
import ru.geekbrains.bridge.theme.Theme;
import ru.geekbrains.bridge.webpage.About;
import ru.geekbrains.bridge.webpage.Project;
import ru.geekbrains.bridge.webpage.WebPage;

public class Main {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();
        Theme aquaTheme = new AquaTheme();
        WebPage about = new About(darkTheme);
        WebPage project = new Project(aquaTheme);
        about.getContent();
        project.getContent();
    }
}
