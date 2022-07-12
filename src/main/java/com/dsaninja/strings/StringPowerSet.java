package com.dsaninja.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * WAP to print all the subsequences of a string (power-set).
 * The subsequence need not be contiguous.
 * <p>
 * ex: "abc" -> {"", a, b, c, ab, bc, ca, abc}
 *
 * <ol> Note:
 *      <li>the order does not matter</li>
 *      <li>for string of length n => subsequences = 2^n</li>
 * </ol>
 */
public class StringPowerSet{

    public List<String> calculateSuperSet(String input){
        return calculateRecursively(input, 0, "", new ArrayList<>());
    }

    private List<String> calculateRecursively(String input, int index, String currentPrefix, List<String> result){
        if(index == input.length()){
            result.add(currentPrefix);
            return result;
        }

        // for every element in the input
        // once include it in the prefix
        // and once exclude it
        calculateRecursively(input, index+1, currentPrefix + input.charAt(index), result);
        calculateRecursively(input, index+1, currentPrefix, result);

        return result;
    }

    @Test
    @DisplayName("test the power set of a non-empty string")
    public void testSuperSet(){
        var result = calculateSuperSet("abc");
        assertEquals(8, result.size());
    }
}
