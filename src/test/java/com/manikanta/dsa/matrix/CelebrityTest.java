package com.manikanta.dsa.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Manikanta Tummalapenta on 01/11/21
 */
public class CelebrityTest {

    @Test
    public void test() {
        Celebrity celebrity = new Celebrity();

        int[][] M = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        Assert.assertEquals(2, celebrity.celebrity(M, 4));

        int[][] N = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}};
        Assert.assertEquals(-1, celebrity.celebrity(N, 4));
    }
}