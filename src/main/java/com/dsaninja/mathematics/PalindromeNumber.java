package com.dsaninja.mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test if a number is palindrome or not
 */
public class PalindromeNumber{

    public boolean isPalindrome(int n){
        return n == reverse(n);
    }

    private int reverseRec(int n){
        return n == 0 ? 0 :
        (n%10) * (int)(Math.pow(10, (int)Math.log10(n))) + reverseRec(n/10);
    }

    private int reverse(int n){
        int res = 0;
        while(n > 0){
            int rem = n%10;
            res = res * 10 + rem;
            n = n /10;
        }

        return res;
    }

    @Test
    public void testPalindrome(){
        assertTrue(isPalindrome(101));
        assertFalse(isPalindrome(123));

        assertEquals(321, reverseRec(123));
        assertEquals(101, reverseRec(101));

    }
}
