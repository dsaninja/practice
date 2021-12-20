package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array where all its elements are sorted in increasing order
 * except two swapped elements, sort it in linear time. Assume there are
 * no duplicates in the array.
 * <p>
 * Example:
 * <pre>
 *     Input:  A[] = [3, 8, 6, 7, 5, 9] or [3, 5, 6, 9, 8, 7] or [3, 5, 7, 6, 8, 9]
 *     Output: A[] = [3, 5, 6, 7, 8, 9]
 * </pre>
 * <p>
 * https://www.techiedelight.com/sort-array-using-one-swap/
 */
public class SortArrayWithTwoSwappedElements{
    public void sort(int[] input){
        int first = -1;
        int second = -1;

        if(input.length <= 1){
            return;
        }

        for(int i = 1; i < input.length; i++){
            if(input[i] < input[i - 1]){
                // if element at i < element at i-1
                // then i-1 is out of position for first time
                if(first == -1){
                    first = i - 1;
                }
                // for second time, it's the element
                // at i index that is out of position
                second = i;
            }
        }

        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

    @Test
    @DisplayName("test array with 2 swapped elements")
    public void sortArray(){
        int[] input = {3, 5, 6, 9, 8, 7};
        sort(input);
        assertArrayEquals(new int[]{3, 5, 6, 7, 8, 9}, input);
    }

    @Test
    @DisplayName("test array with 2 swapped elements when the swapped elements are at last indices")
    public void sortArrayV2(){
        int[] input = {1, 2, 3, 5, 4};
        sort(input);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
    }
}
