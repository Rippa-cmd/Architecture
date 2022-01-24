package ru.geekbrains.strategy;

import ru.geekbrains.strategy.strategies.BubbleSortStrategy;
import ru.geekbrains.strategy.strategies.QuickSortStrategy;
import ru.geekbrains.strategy.strategies.SortStrategy;
import ru.geekbrains.strategy.strategies.Sorter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 4, 3, 2, 8};

        Sorter bubble = new Sorter(new BubbleSortStrategy());
        Sorter quick = new Sorter(new QuickSortStrategy());

        System.out.println(Arrays.toString(bubble.sort(array)));
        System.out.println(Arrays.toString(quick.sort(array)));
    }
}
