package com.dsaninja.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * WAP to find trailing zeros in factorial of a number.
 *
 * We can easily observe that the number of 2s in prime
 * factors is always more than or equal to the number of 5s.
 * So if we count 5s in prime factors, we are done.
 *
 * How to count the total number of 5s in prime factors of n!?
 * A simple way is to calculate floor(n/5). For example, 7!
 * has one 5, 10! has two 5s. It is not done yet, there is
 * one more thing to consider. Numbers like 25, 125, etc
 * have more than one 5. For example, if we consider 28!
 * we get one extra 5 and the number of 0s becomes 6.
 *
 * Handling this is simple, first, divide n by 5 and remove
 * all single 5s, then divide by 25 to remove extra 5s, and so on.
 * <a href="https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/">Trailing Zero</a>
 */
public class TrailingZerosInFactorial{
    /**
     * Trailing 0s in n! = Count of 5s in prime factors of n!
     *                   = floor(n/5) + floor(n/25) + floor(n/125) + ....
     * @param n input
     * @return number of trailing zeros
     */
    public int trailingZeros(int n){
        int res = 0;
        while(n > 0){
            res = res + n/5;
            n = n /5;
        }
        
        return res;
    }
    
    @Test
    public void testZeros(){
        assertEquals(0, trailingZeros(2));
        assertEquals(0, trailingZeros(3));
        assertEquals(0, trailingZeros(4));
        assertEquals(1, trailingZeros(5));
        assertEquals(1, trailingZeros(6));
        assertEquals(1, trailingZeros(7));
        assertEquals(1, trailingZeros(8));
        assertEquals(2, trailingZeros(10));
        assertEquals(6, trailingZeros(25));
    }
}
