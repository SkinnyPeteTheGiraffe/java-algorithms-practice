package com.bobbyplunkett.testing.utils;

import java.util.Arrays;

/**
 * com.bobbyplunkett.testing.utils
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public class RandomTestDataGenerator {

    public static class RandomTestData {
        private int[] unsorted;
        private int[] sorted;

        public RandomTestData(int[] unsorted, int[] sorted) {
            this.unsorted = unsorted;
            this.sorted = sorted;
        }

        public int[] getUnsorted() {
            return unsorted;
        }

        public int[] getSorted() {
            return sorted;
        }
    }

    public static RandomTestData getRandomTestData(int size, int valueDeviation) {
        int[] unsortedArray = new int[size];
        int[] sortedArray = new int[size];
        for(int i = 0; i < size; i++) {
            int randomNumber = (int)(Math.random() * valueDeviation) * (Math.random() > 0.5 ? 1 : -1);
            unsortedArray[i] = randomNumber;
            sortedArray[i] = randomNumber;
        }
        Arrays.sort(sortedArray);
        return new RandomTestData(unsortedArray, sortedArray);
    }
}
