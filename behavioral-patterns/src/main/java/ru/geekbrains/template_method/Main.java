package ru.geekbrains.template_method;

public class Main {
    public static void main(String[] args) {
        AndroidBuilder androidBuilder = new AndroidBuilder();
        IosBuilder iosBuilder = new IosBuilder();

        androidBuilder.build();

        iosBuilder.build();
    }
}
