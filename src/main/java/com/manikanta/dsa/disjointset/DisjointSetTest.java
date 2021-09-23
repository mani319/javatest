package com.manikanta.dsa.disjointset;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 23/09/21
 */
public class DisjointSetTest {

    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(1, 2, 3, 4, 5);
        DisjointSet dj = new DisjointSet(nums);

        // Merge 3,2
        dj.union(3, 2);
        // Merge 2,1
        dj.union(2, 1);
        // Merge 4, 5
        dj.union(4, 5);

        // sets after changing pointers -> 3->2->1, 4->5
        // 1 is root of 3,2,1 set. 5 is root of 4,5 set.
        System.out.println(dj.parentMap);

        // Get set root for each num
        for (int num : nums) {
            System.out.print(dj.find(num) + " ");
        }
        System.out.println();
    }
}
