package ru.geekbrains.strategy.strategies;

public class Sorter {

    private final SortStrategy sorter;

    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public int[] sort(int[] array) {
        return sorter.sort(array);
    }
}
