package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an unsorted integer array, find a pair with the given sum in it.
 * For example:
 * <pre>
 *      Input:
 *      nums = [8, 7, 2, 5, 3, 1]
 *      target = 10
 *      Output:
 *      Pair found (8, 2) or Pair found (7, 3)
 *
 *      Input:
 *      nums = [5, 2, 6, 8, 1, 9]
 *      target = 12
 *      Output: Pair not found
 * </pre>
 *
 * https://www.techiedelight.com/find-pair-with-given-sum-array/
 */
public class PairWithGivenSum {

    public boolean pairWithSum(int[] input, int sum){
        Set<Integer> hash = new HashSet<>();
        AtomicBoolean present = new AtomicBoolean(false);

        Arrays.stream(input).forEach(element -> {
            if(hash.contains(sum - element)){
                present.set(true);
            }
            hash.add(element);
        });

        return present.get();
    }

    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************

    @Test
    @DisplayName("test for presence when there exist a pair that adds to match the sum")
    public void testForPresence(){
        boolean present = pairWithSum(new int[]{8, 7, 2, 5, 3, 1}, 10);
        assertTrue(present);
    }

    @Test
    @DisplayName("test for presence when there does NOT exist any pair that adds to match the sum")
    public void testForAbsence(){
        boolean present = pairWithSum(new int[]{8, 7, 2, 5, 3, 1}, 2);
        assertFalse(present);
    }
}
