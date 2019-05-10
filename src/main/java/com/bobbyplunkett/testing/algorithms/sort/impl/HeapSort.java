package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.algorithms.sort.SortingAlgorithm;

import java.util.Arrays;

/**
 * In computer science, heapsort is a comparison-based sorting algorithm. Heapsort can be thought of as an improved
 * selection sort: like that algorithm, it divides its input into a sorted and an unsorted region, and it iteratively
 * shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The improvement
 * consists of the use of a heap data structure rather than a linear-time search to find the maximum.[1]
 *
 * Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a
 * more favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but it is not a stable sort.
 *
 * Heapsort was invented by J. W. J. Williams in 1964.[2] This was also the birth of the heap, presented already by
 * Williams as a useful data structure in its own right.[3] In the same year, R. W. Floyd published an improved version
 * that could sort an array in-place, continuing his earlier research into the treesort algorithm.[3]
 *
 * Source: https://en.wikipedia.org/wiki/Heapsort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class HeapSort implements SortingAlgorithm {

    private int[] numbers;
    private int iterations;

    public HeapSort(int[] numbers) {
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
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(numbers, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
            heapify(numbers, i, 0);
        }
    }

    private void heapify(int[] numbers, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && numbers[left] > numbers[largest]){
            largest = left;
        }
        if (right < size && numbers[right] > numbers[largest]){
            largest = right;
        }
        if (largest != index)
        {
            int swap = numbers[index];
            numbers[index] = numbers[largest];
            numbers[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(numbers, size, largest);
        }
        iterations++;
    }

    @Override
    public int getIterations() {
        return iterations;
    }
}
