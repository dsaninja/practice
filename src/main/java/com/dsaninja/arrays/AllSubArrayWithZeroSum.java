package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array, print all SubArrays with zero-sum.
 *
 * <pre>
 * Input:  { 4, 2, -3, -1, 0, 4 }
 * SubArrays with zero-sum are:
 * { -3, -1, 0, 4 }
 * { 0 }
 * </pre>
 * <p>
 * Note that the problem deals with SubArrays that are contiguous,
 * i.e., whose elements occupy consecutive positions in the array.
 * <p>
 * https://www.techiedelight.com/find-sub-array-with-0-sum/
 */
public class AllSubArrayWithZeroSum {

    public void printAllSubArraysWithZeroSum(int[] input) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        int sum = 0;

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        cache.put(0, list);

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (cache.containsKey(sum)) {
                List<Integer> elements = cache.get(sum);
                for (Integer value: elements) {
                    System.out.println("Subarray [" + (value + 1) + "…" + i + "]");
                }
            }

            cache.putIfAbsent(sum, new ArrayList<>());
            cache.get(sum).add(i);
        }
    }

    @Test
    public void test(){
        printAllSubArraysWithZeroSum(new int[]{ 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 });
    }

}
