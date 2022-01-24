package ru.geekbrains.state.states;

public class LowerCase implements WritingState{
    @Override
    public void write(String words) {
        System.out.println(words.toLowerCase());
    }
}
