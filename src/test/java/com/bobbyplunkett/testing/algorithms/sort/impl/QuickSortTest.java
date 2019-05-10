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
public class QuickSortTest {

    @Test
    public void getSorted() {
        RandomTestDataGenerator.RandomTestData data = RandomTestDataGenerator.getRandomTestData(1000, 10000);
        QuickSort quickSort = new QuickSort(data.getUnsorted());
        long timestamp = System.currentTimeMillis();
        int[] quickSorted = quickSort.getSorted();
        timestamp = System.currentTimeMillis() - timestamp;
        System.out.printf("Completed %s with %d iterations in %dms!\n", QuickSort.class.getSimpleName(), quickSort.getIterations(), timestamp);
        assertNotNull("Sorted array returned null!", quickSort);
        assertTrue("Sorted array returned empty!", quickSorted.length > 0);
        assertArrayEquals("Sorted does not match Arrays.sort counterpart!", quickSorted, data.getSorted());
    }
}