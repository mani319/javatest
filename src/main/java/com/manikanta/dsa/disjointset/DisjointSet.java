package com.manikanta.dsa.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manikanta Tummalapenta on 23/09/21
 *
 * Ref - https://www.youtube.com/watch?v=UBY4sF86KEY
 */
public class DisjointSet {

    Map<Integer, Integer> parentMap = new HashMap<>();
    Map<Integer, Integer> depthMap = new HashMap<>(); // depth of root will be found. Needed to optimise find call.

    public DisjointSet(Integer maxNum) {
        for (int i = 0; i < maxNum; i++) {
            this.parentMap.put(i, i);
        }
    }

    public DisjointSet(List<Integer> nums) {
        // Initially each number is parents of itself and a set itself.
        for (Integer num : nums) {
            this.parentMap.put(num, num);
            this.depthMap.put(num, 0); // Initial depth is 0 as all nums are roots.
        }
    }

    // This gives root of set inside disjoint set which this elem belongs to - O(logn)
    public Integer find(Integer num) {
        // Root is where it's parent is itself. So terminate
        if (num.equals(parentMap.get(num))) {
            return num;
        }

        // otherwise recur for parent
        return find(parentMap.get(num));
    }

    // Merges 2 sets inside disjoint set - O(1)
    public void union(Integer s1, Integer s2) {
        parentMap.put(s1, s2);
    }

    // To improve find, we need to make the tree more flatten instead of increase depth
    // This union method will improve the performance of find.
    public void improvedUnion(Integer s1, Integer s2) {
        // Map to set which ever have higher depth.
        if (depthMap.get(s1) > depthMap.get(s2)) {
            parentMap.put(s2, s1);
        } else if (depthMap.get(s1) < depthMap.get(s2)) {
            parentMap.put(s1, s2);
        } else {
            // In case both have same depth, then point to any of those and increment depth.
            parentMap.put(s1, s2);
            depthMap.put(s1, depthMap.get(s1)+1);
        }
    }
}
