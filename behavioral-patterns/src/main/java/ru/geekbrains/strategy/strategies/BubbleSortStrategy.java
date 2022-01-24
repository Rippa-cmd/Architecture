package ru.geekbrains.strategy.strategies;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Sorting using bubble sort");

        for (int out = array.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int dummy = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = dummy;
                }
            }
        }

        return array;
    }
}
