package com.dsaninja.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * WAP to count the total paths from the top left
 * cell of a matrix to the bottom right cell of a
 * matrix under the condition that only right or
 * down transitions are allowed.
 */
public class CountPaths{

    /**
     * The problem can be divided into sub problems under
     * the fact that in case of a single row or column, there
     * is only a single path.
     *
     * @param m rows count
     * @param n cols count
     * @return total paths
     */
    public int count(int m, int n){
        if(m == 1 || n == 1){
            return 1;
        }

        return count(m - 1, n) + count(m, n - 1);
    }

    @Test
    public void testPaths(){
        assertEquals(6, count(3,3));
    }
}
