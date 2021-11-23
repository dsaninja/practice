package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array, find a contiguous subarray within it that has the largest sum.
 * For example:
 * <pre>
 *      Input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 *      Output: Subarray with the largest sum is {4, -1, 2, 1} with sum 6.
 *  </pre>
 * <p>
 * https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 */
public class KadanesAlgo{

    public int largestSum(int[] input){
        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // traverse the given array
        for(int element : input){
            // update the maximum sum of subarray "ending" at index `element` (by adding the
            // current element to maximum sum ending at previous index)
            maxEndingHere = maxEndingHere + element;

            // maximum sum should be more than the current element
            maxEndingHere = Integer.max(maxEndingHere, element);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    @Test
    @DisplayName("find largest sum for an array with -ve values")
    public void findLargestSum(){
        int sum = largestSum(new int[]{-8, -3, -6, -2, -5, -4});
        assertEquals(-2, sum);
    }

    @Test
    @DisplayName("find largest sum for an array with +ve and -ve values")
    public void findLargestSumV2(){
        int sum = largestSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, sum);
    }
}
