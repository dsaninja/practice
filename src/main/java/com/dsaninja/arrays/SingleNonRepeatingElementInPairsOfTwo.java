package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Find a single non-repeating element in an array
 * when all other elements occur twice
 * <p>
 * [1,2,3,1,3,2,5] => 5
 */
public class SingleNonRepeatingElementInPairsOfTwo{

    public int findNonRepeatingElement(int[] input){
        int res = 0;
        for(int elem : input){
            res = res ^ elem;
        }

        return res;
    }

    @Test
    public void findNonRepeatingElement(){
        assertEquals(5, findNonRepeatingElement(new int[]{1, 2, 3, 1, 3, 2, 5}));
    }
}
