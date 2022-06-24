package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * WAP to print sub array with max sum.
 *
 * <pre>
 *     input:  {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 *     output: {4, -1, 2, 1}
 *
 *     input:  {8, -7, -3, 5, 6, -2, 3, -4, 2}
 *     output: {5, 6, -2, 3}
 * </pre>
 *
 * @see KadanesAlgo
 */
public class PrintContSubArrayWithMaxSum{
    public int[] print(int[] input){
        int globalMax = Integer.MIN_VALUE;
        int maxSoFar = 0;

        int start =0, globalStart = 0, globalEnd = 0;

        for(int i = 0; i < input.length; i++){
            maxSoFar+= input[i];

            if(maxSoFar < input[i]){
                maxSoFar = input[i];
                start = i;
            }

            if(globalMax < maxSoFar){
                globalMax = maxSoFar;

                // this is required for all -ve array input
                globalStart = start;
                globalEnd = i;
            }
        }

        return Arrays.copyOfRange(input, globalStart, globalEnd+1);
    }

    @Test
    public void test(){
        assertArrayEquals(new int[]{4, -1, 2, 1}, print(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertArrayEquals(new int[]{5, 6, -2, 3}, print(new int[]{8, -7, -3, 5, 6, -2, 3, -4, 2}));
        assertArrayEquals(new int[]{6, -2, -3, 1, 5}, print(new int[]{-2, -5, 6, -2, -3, 1, 5, -6}));
        assertArrayEquals(new int[]{7, -4, 2, 5}, print(new int[]{2, -3, 7, -4, 2, 5, -8, 6, -1}));
        assertArrayEquals(new int[]{-1}, print(new int[]{-4,-2,-1,-6}));
    }
}
