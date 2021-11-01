package com.manikanta.dsa.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Manikanta Tummalapenta on 30/10/21
 */
public class MinNumOfTowersTest {

    @Test
    public void test() {
        MinNumOfTowers minNumOfTowers = new MinNumOfTowers();

        Assert.assertEquals(5,
                minNumOfTowers.minNumOfTowers(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 1));

        Assert.assertEquals(3,
                minNumOfTowers.minNumOfTowers(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 2));

        Assert.assertEquals(2,
                minNumOfTowers.minNumOfTowers(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 3));

        Assert.assertEquals(2,
                minNumOfTowers.minNumOfTowers(new int[]{1, 2, 3, 4, 5}, 1));
    }
}