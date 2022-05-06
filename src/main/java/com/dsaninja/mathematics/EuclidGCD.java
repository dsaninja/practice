package com.dsaninja.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GCD of two numbers is the largest number that divides both of them.
 * A simple way to find GCD is to factorize both numbers and multiply
 * common prime factors.
 *
 * <a href="https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/">Euclid GCD</a>
 */
public class EuclidGCD{
    public static int gcd(int a, int b){
        if (b == 0) return a;

        // both works return gcd(b%a, a);
        return gcd(b, a%b); 
    }
    
    @Test
    public void testGCD(){
        assertEquals(5, gcd(10,15));
        assertEquals(5, gcd(35,10));
        assertEquals(1, gcd(31,2));
    }
}
