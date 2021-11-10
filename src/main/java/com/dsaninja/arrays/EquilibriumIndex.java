package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array, find the equilibrium index in it.
 * For an array A consisting n elements, index i is an equilibrium
 * index if the sum of elements of subarray A[0…i-1] is equal to the
 * sum of elements of subarray A[i+1…n-1]. i.e.
 * <p>
 * https://www.techiedelight.com/find-equilibrium-index-array/
 */
public class EquilibriumIndex{

    public int findEquilibriumIndex(int[] input){
        int sum = IntStream.of(input).sum();

        // we need to find two sections left and right to index i
        // such that sum(left) to i == sum (right) to i

        // Now as sum(left) + i + sum(right) = total
        // sum(left) == total - sum(right) - i
        // hence, sum(L) == sum(R) can be written as
        // total - sum(right) - i == sum(right)
        // total - (sum(right) + i) == sum(right)

        int rightSum = 0;

        for(int i = input.length - 1; i >= 0; i--){
            if(rightSum == sum - (input[i] + rightSum)){
                // if all indices are required
                // collect and return those here
                return i;
            }
            rightSum = input[i] + rightSum;
        }

        return -1;
    }

    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************

    @Test
    @DisplayName("test presence of equilibrium index")
    public void testEquilibriumPresence(){
        int equilibriumIndex = findEquilibriumIndex(new int[]{0, -3, 5, -4, -2, 3, 1, 0});
        assertEquals(7, equilibriumIndex);
    }

    @Test
    @DisplayName("test absence of equilibrium index")
    public void testEquilibriumAbsence(){
        int equilibriumIndex = findEquilibriumIndex(new int[]{1, 2, 3, 4, 5});
        assertEquals(-1, equilibriumIndex);
    }
}
