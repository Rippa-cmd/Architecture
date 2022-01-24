package ru.geekbrains.state.states;

public class UpperCase implements WritingState{
    @Override
    public void write(String words) {
        System.out.println(words.toUpperCase());
    }
}
