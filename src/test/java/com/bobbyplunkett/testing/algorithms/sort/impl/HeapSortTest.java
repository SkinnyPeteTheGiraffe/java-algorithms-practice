package com.bobbyplunkett.testing.algorithms.sort.impl;

import com.bobbyplunkett.testing.utils.RandomTestDataGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * com.bobbyplunkett.testing.algorithms.sort.impl
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class HeapSortTest {

    @Test
    public void getSorted() {
        RandomTestDataGenerator.RandomTestData data = RandomTestDataGenerator.getRandomTestData(1000, 10000);
        HeapSort heapSort = new HeapSort(data.getUnsorted());
        long timestamp = System.currentTimeMillis();
        int[] insertionSorted = heapSort.getSorted();
        timestamp = System.currentTimeMillis() - timestamp;
        System.out.printf("Completed %s with %d iterations in %dms!\n", HeapSort.class.getSimpleName(), heapSort.getIterations(), timestamp);
        assertNotNull("Sorted array returned null!", heapSort);
        assertTrue("Sorted array returned empty!", insertionSorted.length > 0);
        assertArrayEquals("Sorted array does not match Arrays.sort counterpart!", insertionSorted, data.getSorted());
    }
}