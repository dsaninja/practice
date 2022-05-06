package com.dsaninja.mathematics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a number n, print all primes smaller than or
 * equal to n. It is also given that n is a small number.
 *
 * <a href="https://www.geeksforgeeks.org/sieve-of-eratosthenes/">sieve-of-eratosthenes</a>
 */
public class SieveOfEratosthenes{

    public boolean[] findPrimes(int cutOff){
        boolean[] primes = new boolean[cutOff + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        // run loop upto sqrt(n)
        for(int i = 2; i*i <= cutOff; i++){
            // if its not already marked as false
            if(primes[i]){
                // mark all multiples of i as false starting
                // from i*2
                for(int j = 2 * i; j <= cutOff; j = j + i){
                    primes[j] = false;
                }
            }
        }

        return primes;
     }

     @Test
     public void testPrimes(){
        boolean[] primes = findPrimes(50);
        assertTrue(primes[2]);
        assertTrue(primes[13]);
        assertTrue(primes[19]);
        assertTrue(primes[17]);

        assertFalse(primes[4]);
        assertFalse(primes[14]);
        assertFalse(primes[24]);
        assertFalse(primes[16]);
        assertFalse(primes[48]);
        assertFalse(primes[50]);
     }

}
