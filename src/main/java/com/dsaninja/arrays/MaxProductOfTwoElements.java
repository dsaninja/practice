package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array, find the maximum product of two integers in it.
 * <p>
 * For example, consider array {-10, -3, 5, 6, -2}.
 * The maximum product is the (-10, -3) or (5, 6) pair.
 * <p>
 * https://www.techiedelight.com/find-maximum-product-two-integers-array/
 */
public class MaxProductOfTwoElements{

    // the max product can be the result of either top two
    // largest elements or smallest elements (both -ve)
    public int[] findMaxProductParticipants(int[] input){

        int max = input[0], secondMax = Integer.MIN_VALUE;
        int min = input[0], secondMin = Integer.MAX_VALUE;

        for(int i = 1, inputLength = input.length; i < inputLength; i++){
            int element = input[i];
            if(element > max){
                secondMax = max;
                max = element;
            } else if(element > secondMax){
                secondMax = element;
            }

            if(element < min){
                secondMin = min;
                min = element;
            } else if(element < secondMin){
                secondMin = element;
            }
        }

        // prefer +ve pair
        return max * secondMax >= min * secondMin ? new int[]{max, secondMax} : new int[]{min, secondMin};
    }

    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************

    @Test
    @DisplayName("test the max product participants for -ve elements")
    public void testMaxProductParticipantsV1(){
        int[] input = { -10, -3, 2, 8, -20 };
        int[] maxProductParticipants = findMaxProductParticipants(input);

        assertArrayEquals(new int[]{-20, -10}, maxProductParticipants);
    }

    @Test
    @DisplayName("test the max product participants for +ve elements")
    public void testMaxProductParticipantsV2(){
        int[] input = { -10, -3, 6, 5, -2 };
        int[] maxProductParticipants = findMaxProductParticipants(input);

        assertArrayEquals(new int[]{6, 5}, maxProductParticipants);
    }

}
