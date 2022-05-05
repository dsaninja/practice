package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Find a single non-repeating element in an array
 * when all other elements occur k times.
 *
 * k=2; [1,2,3,1,3,2,5] => 5
 */
public class SingleNonRepeatingElementInPairsOfK{

    public int findUniqueElement(int[] input, int k){
        // assuming int is 32 bit, lets create
        // a freq array of size 32 for every single
        // bit of the int array elements
        int[] freq = new int[32];

        for(int elem : input){
            for(int i = 0; i < 32; i++){
                // prepare a mask to validate
                // ith bit by left shifting 1
                // i places; i.e. a number having
                // only ith bit set.
                int mask = 1 << i;
                if((elem & mask) != 0){
                    freq[i] ++;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 32; i++){
            // kth modulo with input[i] will leave
            // only that bit set which was set for
            // non repeating element as otherwise
            // it would have been cancelled due to
            // duplicate elements

            // multiply it with 2^i
            // also note that multiplication with 2^i
            // can start from either end
            // binary 101
            //           == 1 x 2^0 + 0 x 2^1 + 1 x 2^2
            //           == 1 x 2^2 + 0 x 2^1 + 1 x 2^0
            // 1 << i == Math.pow(2, i)
            res += (freq[i] % k) * (1 << i);
        }

        return res;
    }

    @Test
    public void findUnique(){
        assertEquals(5, findUniqueElement(new int[]{1,2,3,1,3,2,5}, 2));
        assertEquals(5, findUniqueElement(new int[]{1,2,3,1,3,2,5,1,2,3}, 3));
    }
}
