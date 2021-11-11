package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array, move all zeros present in it to the end.
 * The solution should maintain the relative order of items in the array
 * and should not use constant space.
 * <p>
 * https://www.techiedelight.com/move-zeros-present-array-end/
 */
public class MoveZerosToEnd{

    public void moveByCountingZeros(int[] input){
        int availableSlot = 0;
        for(int element : input){
            if(element != 0){
                input[availableSlot++] = element;
            }
        }

        // fill remaining slots with 0
        Arrays.fill(input, availableSlot, input.length, 0);
    }

    public void moveByQuickSortPartitioning(int[] input){
        int pivot = 0;
        int j = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] != pivot){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;

                j++;
            }
        }
    }

    @Test
    @DisplayName("test by counting zero method")
    public void testByCountingZeroMethod(){
        int[] ip = {1, 0, 2, 0, 0, 0, 3, 4, 5};
        moveByCountingZeros(ip);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0}, ip);
    }

    @Test
    @DisplayName("test by quick sort partitioning method")
    public void testByQuickSortPartitioningMethod(){
        int[] ip = {1, 0, 2, 0, 0, 0, 3, 4, 5};
        moveByQuickSortPartitioning(ip);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0}, ip);
    }
}
