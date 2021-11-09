package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an integer array, check if it contains a subarray having zero-sum.
 * For example:
 * <pre>
 *      Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 *      Output: Subarray with zero-sum exists
 *
 *      The sub-arrays with a sum of 0 are:
 *      { 3, 4, -7 }
 *      { 4, -7, 3 }
 *      { -7, 3, 1, 3 }
 *      { 3, 1, -4 }
 *      { 3, 1, 3, 1, -4, -2, -2 }
 *      { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 *  </pre>
 * <p>
 * <p>
 * Note that the problem deals with sub-arrays that are contiguous,
 * i.e., whose elements occupy consecutive positions in the array.
 * <p>
 * https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/
 */
public class ZeroSumSubarray {

    public boolean checkIfAnySubArraySumsToZero(int[] input) {
        int runningSum = 0;
        Set<Integer> runningSumCache = new HashSet<>();
        runningSumCache.add(0);

        // [this is front part of the array] [sub array with zero-sum] [this is back of the array]
        //
        //  suppose the sum of the front part of the array was "x", this would have been stored in
        //  our set. And you keep on iterating. When you have reached the end of the sub array with 0
        //  sum, guess what should be the value of the sum variable be? well it should be sum of the
        //  front part + sum of the sub array with sum 0; which is essentially sum of the front part "x"
        // and checking for its presence returns true

        // Now what if the sub array with 0 sum is in the front.
        // [sub array with 0 sum] [back part of the array]
        // We already add 0 to our set before we start iterating. So after iterating over the sub array
        // with contiguous sum the value of sum becomes 0, which is already present in the sub array

        for (int arrayElement : input) {
            runningSum += arrayElement;
            if (runningSumCache.contains(runningSum)) {
                return true;
            }
            runningSumCache.add(runningSum);
        }

        return false;
    }


    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************


    @DisplayName("test the presence of a zero sum subarray")
    @Test
    public void testZeroSumSubArrayV1() {
        assertTrue(checkIfAnySubArraySumsToZero(new int[]{4, -6, 3, -1, 4, 2, 7}));
    }

    @DisplayName("test the absence of a zero sum subarray")
    @Test
    public void testZeroSumSubArrayV2() {
        assertFalse(checkIfAnySubArraySumsToZero(new int[]{1, 2, 3, 4, 5}));
    }
}
