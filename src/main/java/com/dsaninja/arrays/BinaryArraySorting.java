package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a binary array, sort it in linear time and constant space.
 * The output should print all zeroes, followed by all ones.
 * <p>
 * Example:
 * <pre>
 *     Input:  { 1, 0, 1, 0, 1, 0, 0, 1 }
 *     Output: { 0, 0, 0, 0, 1, 1, 1, 1 }
 * </pre>
 * <p>
 * https://www.techiedelight.com/sort-binary-array-linear-time/
 */
public class BinaryArraySorting{

    public void sortByCountingZeros(int[] input){
        int zeros = (int) IntStream.of(input).filter(element -> element == 0).count();

        // now copy so many zeros in the beginning of the array
        // followed by ones
        Arrays.fill(input, 0, zeros, 0);
        Arrays.fill(input, zeros, input.length, 1);
    }

    public void sortByMovingZeroElementsToFrontOfTheArray(int[] input){
        int index = 0;
        for(int element : input){
            if(element == 0){
                // if current element is 0, move it to the beginning of array
                input[index] = 0;
                index++;
            }
        }

        // fill the remaining positions with 1
        Arrays.fill(input, index, input.length, 1);
    }

    public void sortUsingQuickSortPartitioning(int[] input){
        int pivot = 1;
        int index = 0;

        for(int i = 0; i < input.length; i++){
            if(input[i] < pivot){
                int temp = input[i];
                input[i] = input[index];
                input[index] = temp;

                index++;
            }
        }
    }

    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************

    @Test
    @DisplayName("test sorting a binary array using sort by counting zeros")
    public void testSortingByCountingZeros(){
        int[] input = {1, 1, 0, 0, 1, 1, 0};
        sortByCountingZeros(input);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 1}, input);
    }

    @Test
    @DisplayName("test sorting a binary array using sort by moving zeros")
    public void testSortingByMovingZeros(){
        int[] input = {1, 1, 0, 0, 1, 1, 0};
        sortByMovingZeroElementsToFrontOfTheArray(input);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 1}, input);
    }

    @Test
    @DisplayName("test sorting a binary array using quick sort partitioning")
    public void testSortingByQuickSortPartitioning(){
        int[] input = {1, 1, 0, 0, 1, 1, 0};
        sortUsingQuickSortPartitioning(input);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 1}, input);
    }
}
