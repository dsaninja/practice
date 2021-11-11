package com.dsaninja.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array containing duplicates, return
 * the majority element if present. A majority element
 * appears more than n/2 times, where n is the array size.
 * <p>
 * <p>
 * Example: the majority element is 2 in array {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}.
 * <p>
 * https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
 */
public class BoyerMooreMajorityVote{

    /**
     * A O(n) solution with extra O(n) space. Here we keep track of
     * freq of each element and return the first element with freq
     * greater than n/2.
     *
     * @return majority element
     */
    public int majorityElementUsingHashing(int[] input){
        Map<Integer, Integer> freq = new HashMap<>();
        IntStream.of(input).forEach(element -> freq.put(element, freq.getOrDefault(element, 0) + 1));

        return freq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > input.length / 2)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    /**
     * Returns correct element only if there exist a majority element
     * with frequency > n/2.
     *
     * @param input input array
     * @return majority element if present; -1 otherwise
     */
    public int boyerMooreMajorityAlgo(int[] input){
        int majorityCandidate = input[0];
        int freq = 1;

        // for every element
        for(int i = 1; i < input.length; i++){
            // if same as existing ME, increase the freq by 1
            if(majorityCandidate == input[i]){
                freq++;
            } else{
                // otherwise, decrease the freq
                freq--;
            }

            // if freq == 0, it means there exist
            // different elements with total freq
            // more than the freq of majorityCandidate
            // and hence it cannot be majority candidate
            if(freq == 0){
                majorityCandidate = input[i];
                freq = 1;
            }
        }

        // return majority candidate if freq > n/2; -1 otherwise
        final int mc = majorityCandidate;
        return IntStream.of(input).filter(element -> element == mc).count() > input.length / 2 ? majorityCandidate : -1;
    }

    @Test
    @DisplayName("check presence of majority element using hashing method")
    public void testHashingMethodForPresence(){
        int majorityElement = majorityElementUsingHashing(new int[]{1, 1, 2, 3, 4, 5, 1, 1, 1});
        assertEquals(1, majorityElement);
    }

    @Test
    @DisplayName("check absence of majority element using hashing method")
    public void testHashingMethodForAbsence(){
        int majorityElement = majorityElementUsingHashing(new int[]{1, 1, 2, 3, 4, 5, 6, 6, 1});
        assertEquals(-1, majorityElement);
    }

    @Test
    @DisplayName("check presence of majority element using boyer-moore method")
    public void testMooreMethodForPresence(){
        int majorityElement = boyerMooreMajorityAlgo(new int[]{1, 1, 2, 3, 4, 5, 1, 1, 1});
        assertEquals(1, majorityElement);
    }

    @Test
    @DisplayName("check absence of majority element using boyer-moore method")
    public void testMooreMethodForAbsence(){
        int majorityElement = boyerMooreMajorityAlgo(new int[]{1, 1, 2, 3, 4, 5, 6, 6, 1});
        assertEquals(-1, majorityElement);
    }
}
