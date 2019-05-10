package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.algorithms.sort.SortingAlgorithm;

import java.util.Arrays;

/**
 * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm, serving as a systematic
 * method for placing the elements of a random access file or an array in order. Developed by British computer
 * scientist Tony Hoare in 1959[1] and published in 1961,[2] it is still a commonly used algorithm for sorting.
 * When implemented well, it can be about two or three times faster than its main competitors, merge sort and
 * heapsort.[3][contradictory]
 *
 * Quicksort is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation
 * (formally, a total order) is defined. In efficient implementations it is not a stable sort, meaning that the
 * relative order of equal sort items is not preserved. Quicksort can operate in-place on an array, requiring small
 * additional amounts of memory to perform the sorting. It is very similar to selection sort, except that it does not
 * always choose worst-case partition.
 *
 * Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) comparisons to sort n
 * items. In the worst case, it makes O(n2) comparisons, though this behavior is rare.
 *
 * Source: https://en.wikipedia.org/wiki/Quicksort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class QuickSort implements SortingAlgorithm {

    private int[] numbers;
    private int iterations;

    public QuickSort(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getSorted() {
        iterations = 0;
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        sort(sorted, 0, sorted.length - 1);
        return sorted;
    }

    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int index = start - 1;
        for(int i = start; i < end; i++) {
            if(numbers[i] <= pivot) {
                index++;

                int t = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = t;
            }
            iterations++;
        }
        int temp = numbers[index + 1];
        numbers[index + 1] = numbers[end];
        numbers[end] = temp;
        return index + 1;
    }

    private void sort(int[] numbers, int low, int high) {
        if (low < high)
        {
            int pi = partition(numbers, low, high);
            sort(numbers, low, pi - 1);
            sort(numbers, pi + 1, high);
        }
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
