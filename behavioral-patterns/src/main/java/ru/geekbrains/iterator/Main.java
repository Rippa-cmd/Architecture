package ru.geekbrains.iterator;

import java.util.Iterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Iterable<Integer> iterable = () -> new Iterator<>() {
            private int count = 0;
            private final Random random = new Random();

            @Override
            public boolean hasNext() {
                return count < 10;
            }

            @Override
            public Integer next() {
                count++;
                return random.nextInt();
            }
        };
        iterable.forEach(System.out::println);
    }
}
