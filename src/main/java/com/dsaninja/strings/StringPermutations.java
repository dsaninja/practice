package com.dsaninja.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * WAP to generate all permutations for a given
 * input string.
 * <p>
 * ex: "abc" -> {"abc", "bac", "cab", "acb", "bca", "cba"}
 *
 * Note: perm(ip) => op.size() == fact(ip.size())
 */
public class StringPermutations{

    // option-1
    public List<String> permuteViaSubString(String input){
        return permuteViaSubString("", input, new ArrayList<>());
    }

    private List<String> permuteViaSubString(String prefix, String input, List<String> result){
        if(input.length() == 0){
            result.add(prefix);
            return result;
        }

        for(int i = 0 ; i < input.length(); i++){
            permuteViaSubString(prefix + input.charAt(i), input.substring(0, i) + input.substring(i+1), result);
        }

        return result;
    }

    // option-2
    public List<String> permuteViaSwapping(char[] ip, int length, List<String> result){
        if(length == 1){
            result.add(new String(ip));
            return result;
        }

        for(int i = 0; i < length; i++){
            swap(ip, i, length - 1);
            permuteViaSwapping(ip, length - 1, result);
            swap(ip, i, length - 1);
        }

        return result;
    }

    private void swap(char[]ip, int start, int end){
        char temp = ip[start];
        ip[start] = ip[end];
        ip[end] = temp;
    }

    @Test
    @DisplayName("test permute via swapping")
    public void testViaSwapping(){
        var result = permuteViaSwapping("abc".toCharArray(), 3, new ArrayList<>());
        assertEquals(6, result.size());
    }

    @Test
    @DisplayName("test permute via substring")
    public void testViaSubString(){
        var result = permuteViaSubString("abc");
        assertEquals(6, result.size());
    }
}
