package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.algorithms.sort.impl.InsertionSort;
import com.bobbyplunkett.testing.utils.RandomTestDataGenerator;
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

    @Test
    public void getSorted() {
        RandomTestDataGenerator.RandomTestData data = RandomTestDataGenerator.getRandomTestData(1000, 10000);
        InsertionSort insertionSort = new InsertionSort(data.getUnsorted());
        long timestamp = System.currentTimeMillis();
        int[] insertionSorted = insertionSort.getSorted();
        timestamp = System.currentTimeMillis() - timestamp;
        System.out.printf("Completed %s with %d iterations in %dms!\n", InsertionSort.class.getSimpleName(), insertionSort.getIterations(), timestamp);
        assertNotNull("Sorted array returned null!", insertionSort);
        assertTrue("Sorted array returned empty!", insertionSorted.length > 0);
        assertArrayEquals("Sorted does not match Arrays.sort counterpart!", insertionSorted, data.getSorted());
    }
}