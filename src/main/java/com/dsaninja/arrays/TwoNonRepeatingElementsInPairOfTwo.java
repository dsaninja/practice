package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Find two non-repeating element in an array
 * when all other elements occur twice.
 *
 * [1,2,7,3,1,3,2,5] => [5,7]
 */
public class TwoNonRepeatingElementsInPairOfTwo{

    public int[] findNonRepeatingElement(int[] input){
        int res = 0;

        // after this loop res = 5 ^ 7
        for(int elem : input){
            res = res ^ elem;
        }

        // now we need to somehow extract these
        // individual elements from res

        // the following operation will leave
        // only the last set bit in res and all
        // other bits will cancel out
        res = res & -res;

        // now the only set bit in res means the
        // specific bit was different in the two
        // operands 5 and 7 as the XOR between those
        // two left the bit set.

        // Let's create two pairs of elements based
        // on that bit
        int one = 0;
        int two = 0;

        for(int elem : input){
            // when xored with res which contains only
            // 1 set bit that is different in the two operands
            // we group the numbers between one and two
            // both the operands will be in different
            // groups (due to the different bit) and all
            // other elements in their group will cancel out
            // due to being duplicate
            if((elem & res) == 0){
                one = one ^ elem;
            }else{
                two = two ^ elem;
            }
        }

        return new int[]{one, two};
    }

    @Test
    public void testFindNonRepeatingElement(){
        assertArrayEquals(new int[]{5,7}, findNonRepeatingElement(new int[]{1,2,7,3,1,3,2,5}));
    }
}
