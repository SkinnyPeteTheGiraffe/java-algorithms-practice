package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.algorithms.sort.SortingAlgorithm;

import java.util.Arrays;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the
 * list, compares adjacent pairs and swaps them if they are in the wrong order. The pass through the list is repeated
 * until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements
 * "bubble" to the top of the list. Although the algorithm is simple, it is too slow and impractical for most problems
 * even when compared to insertion sort.[2] Bubble sort can be practical if the input is in mostly sorted order with
 * some out-of-order elements nearly in position.
 *
 * Source: https://en.wikipedia.org/wiki/Bubble_sort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class BubbleSort implements SortingAlgorithm {

    private int[] numbers;
    private int iterations;

    public BubbleSort(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getSorted() {
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        sort(sorted);
        return sorted;
    }

    private void sort(int[] numbers) {
        iterations = 0;
        int length = numbers.length;
        for(int i = 0; i < length - 1; i++) {
            for(int j = 0; j < length - i - 1; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int t = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = t;
                }
                iterations++;
            }
        }
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
