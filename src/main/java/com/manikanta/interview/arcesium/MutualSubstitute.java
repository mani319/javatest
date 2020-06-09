package com.manikanta.interview.arcesium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manikanta Tummalapenta on 06 Jan 2020
 */
public class MutualSubstitute {

    static String doMutualSubstitution(String s, char[] subFirst, char[] subSecond) {
        // Use a map of letter to set and work on it.
        // Construct the string back and return.
        Map<Character, List<Integer>> charToIndexSet = new HashMap<>();
        for (int i = 0; i  < s.length(); i++) {
            List<Integer> indexes = charToIndexSet.getOrDefault(s.charAt(i), new ArrayList<>());
            indexes.add(i);
            charToIndexSet.put(s.charAt(i), indexes);
        }

        int m = subFirst.length;
        for (int i = 0; i < m; i++) {
            Character char1 = subFirst[i];
            Character char2 = subSecond[i];

            List<Integer> char1Backup = charToIndexSet.getOrDefault(char1, new ArrayList<>());
            List<Integer> char2Backup = charToIndexSet.getOrDefault(char2, new ArrayList<>());
            charToIndexSet.put(char1, char2Backup);
            charToIndexSet.put(char2, char1Backup);
        }

        char[] charArr = new char[s.length()];
        for (Map.Entry<Character, List<Integer>> entry : charToIndexSet.entrySet()) {
            if (entry.getValue() == null || entry.getValue().isEmpty()) {
                continue;
            }
            for (Integer index : entry.getValue()) {
                charArr[index] = entry.getKey();
            }
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        String s = "coder";
        char[] subFirst = {'c'};
        char[] subSecond = {'o'};
        System.out.println(doMutualSubstitution(s, subFirst, subSecond));
    }
}
