package ru.geekbrains.state.states;

public class DefaultText implements WritingState{
    @Override
    public void write(String words) {
        System.out.println(words);
    }
}
