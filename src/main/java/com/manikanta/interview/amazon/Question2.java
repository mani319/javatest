package com.manikanta.interview.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 28 May 2020
 */
public class Question2 {

    List<Integer> lengthEachScene(List<Character> inputList) {
        // Base case for empty List - return empty list
        if (null == inputList || inputList.size() == 0) {
            return new ArrayList<>();
        }

        int n = inputList.size();
        List<Integer> result = new ArrayList<>();

        // Traverse the string and while traversing mark the last index of each Character
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[inputList.get(i) - 'a'] = i;
        }

        // Now find the end of current sub string
        int end = 0, begin = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIndex[inputList.get(i) - 'a']);

            if (end == i) {
                result.add(end - begin + 1);
                begin = end + 1;
            }
        }

        return result;
    }
}
