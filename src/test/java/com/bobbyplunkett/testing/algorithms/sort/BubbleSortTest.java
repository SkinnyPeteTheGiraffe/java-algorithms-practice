package com.bobbyplunkett.testing.algorithms.sort;

import com.bobbyplunkett.testing.algorithms.sort.impl.BubbleSort;
import com.bobbyplunkett.testing.utils.RandomTestDataGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * com.bobbyplunkett.testing.algorithms.sort
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class BubbleSortTest {

    @Test
    public void getSorted() {
        RandomTestDataGenerator.RandomTestData data = RandomTestDataGenerator.getRandomTestData(1000, 10000);
        BubbleSort bubbleSort = new BubbleSort(data.getUnsorted());
        long timestamp = System.currentTimeMillis();
        int[] insertionSorted = bubbleSort.getSorted();
        timestamp = System.currentTimeMillis() - timestamp;
        System.out.printf("Completed %s with %d iterations in %dms!\n", BubbleSort.class.getSimpleName(), bubbleSort.getIterations(), timestamp);
        assertNotNull("Sorted array returned null!", bubbleSort);
        assertTrue("Sorted array returned empty!", insertionSorted.length > 0);
        assertArrayEquals("Sorted array does not match Arrays.sort counterpart!", insertionSorted, data.getSorted());
    }
}