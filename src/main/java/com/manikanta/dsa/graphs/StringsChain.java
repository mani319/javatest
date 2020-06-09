package com.manikanta.dsa.graphs;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 16 May 2020
 *
 * Ref - https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 */
public class StringsChain {

    static boolean canBeChained(String[] words) {
        Graph g = new Graph(26);

        for (String word : words) {
            int fromV = word.charAt(0) - 'a';
            int toV = word.charAt(word.length()-1) - 'a';

            g.addEdge(fromV, toV);
        }

        return EulerCircuit.isEulerCircuitPresent(g);
    }

    public static void main(String[] args) {
        String arr1[] =  {"for", "geek", "rig", "kaf"};
        Assert.assertTrue(canBeChained(arr1));

        String arr2[] =  {"aab", "abb"};
        Assert.assertFalse(canBeChained(arr2));

        String arr3[] = {"geek", "king"};
        Assert.assertTrue(canBeChained(arr3));

        String arr4[] = {"aab", "bac", "aaa", "cda"};
        Assert.assertTrue(canBeChained(arr4));

        String arr5[] = {"aaa", "bbb", "baa", "aab"};
        Assert.assertTrue(canBeChained(arr5));

        String arr6[] = {"aaa"};
        Assert.assertTrue(canBeChained(arr6));

        String arr7[] = {"aaa", "bbb"};
        Assert.assertFalse(canBeChained(arr7));

        String arr8[] = {"abc", "efg", "cde", "ghi", "ija"};
        Assert.assertTrue(canBeChained(arr8));

        String arr9[] = {"ijk", "kji", "abc", "cba"};
        Assert.assertFalse(canBeChained(arr9));
    }
}
