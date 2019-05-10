package com.bobbyplunkett.testing.algorithms.sort;

import com.bobbyplunkett.testing.algorithms.sort.impl.InsertionSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * com.bobbyplunkett.testing.algorithms.sort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class InsertionSortTest {

    private static final int LIMIT_DEVIATION = 10000;
    private static final int ARRAY_SIZE = 1000;
    private static int[] unsortedArray;
    private static int[] sortedArray;

    static {
        unsortedArray = new int[ARRAY_SIZE];
        sortedArray = new int[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            int randomNumber = (int)(Math.random() * LIMIT_DEVIATION) * (Math.random() > 0.5 ? 1 : -1);
            unsortedArray[i] = randomNumber;
            sortedArray[i] = randomNumber;
        }
        Arrays.sort(sortedArray);
    }

    @Test
    public void getSorted() {
        InsertionSort insertionSort = new InsertionSort(unsortedArray);
        long timestamp = System.currentTimeMillis();
        int[] insertionSorted = insertionSort.getSorted();
        timestamp = System.currentTimeMillis() - timestamp;
        System.out.printf("Completed %s with %d iterations in %dms!\n", InsertionSort.class.getSimpleName(), insertionSort.getIterations(), timestamp);
        assertNotNull("Sorted array returned null!", insertionSort);
        assertTrue("Sorted array returned empty!", insertionSorted.length > 0);
        assertArrayEquals("Sorted does not match Arrays.sort counterpart!", insertionSorted, sortedArray);
    }
}