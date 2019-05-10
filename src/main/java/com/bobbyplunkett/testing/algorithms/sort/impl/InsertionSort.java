package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.algorithms.sort.SortingAlgorithm;

import java.util.Arrays;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is
 * much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * However, insertion sort provides several advantages:
 *
 * - Simple implementation: Jon Bentley shows a three-line C version, and a five-line optimized version[2]
 * - Efficient for (quite) small data sets, much like other quadratic sorting algorithms
 * - More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as selection sort or
 *   bubble sort
 * - Adaptive, i.e., efficient for data sets that are already substantially sorted: the time complexity is O(kn) when
 *   each element in the input is no more than k places away from its sorted position
 * - Stable; i.e., does not change the relative order of elements with equal keys
 * - In-place; i.e., only requires a constant amount O(1) of additional memory space
 * - Online; i.e., can sort a list as it receives it
 * - When people manually sort cards in a bridge hand, most use a method that is similar to insertion sort.[3]
 *
 * Source: https://en.wikipedia.org/wiki/Insertion_sort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class InsertionSort implements SortingAlgorithm {

    private int[] numbers;
    private int iterations;

    public InsertionSort(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getSorted() {
        this.iterations = 0;
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        sort(sorted, sorted.length - 1);
        return sorted;
    }

    private void sort(int[] numbers, int index) {
        if(index > 0) {
            sort(numbers, index - 1);
            int a = numbers[index];
            int i = index - 1;
            while (i >= 0 && numbers[i] > a) {
                numbers[i + 1] = numbers[i];
                i--;
                iterations++;
            }
            numbers[i + 1] = a;
        }
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
