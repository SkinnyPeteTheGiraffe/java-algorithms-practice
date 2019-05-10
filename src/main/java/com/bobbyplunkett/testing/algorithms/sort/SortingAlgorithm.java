package com.bobbyplunkett.testing.algorithms.sort;

/**
 * A default structure used for creating Sorting Algorithm implementations creating a common type between all the
 * implemented algorithms.
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 5/9/2019
 */
public interface SortingAlgorithm {

    /**
     * Get the sorted numbers generated via the implemented algorithm.
     * @return sorted list of input numbers
     */
    int[] getSorted();

    /**
     * How many iterations occurred during the sorting process. Used for profiling and debugging.
     * @return the amount of iterations
     */
    int getIterations();
}
