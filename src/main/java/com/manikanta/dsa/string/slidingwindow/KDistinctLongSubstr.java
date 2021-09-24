package com.manikanta.dsa.string.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class KDistinctLongSubstr {

    public static String findLongestSubstring(String str, int k) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int resultStart = 0, resultEnd = 0;
        int[] charCount = new int[128];
        Set<Character> unique = new HashSet<>();

        for (int end = 0, start = 0; end < str.length(); end++) {
            // Update unique and charCount
            unique.add(str.charAt(end));
            charCount[str.charAt(end)]++;

            // Move start till unique == k.
            while (unique.size() > k) {
                if (--charCount[str.charAt(start)] == 0) {
                    unique.remove(str.charAt(start));
                }
                start++;
            }

            // Check if existing result window is smaller than current window.
            if (end - start > resultEnd - resultStart) {
                resultStart = start;
                resultEnd = end;
            }
        }

        return str.substring(resultStart, resultEnd + 1);
    }

    public static void main(String[] args) {
        String str = "abcbdbdbbdcdabd";
        int k = 2;

        System.out.print(findLongestSubstring(str, k));
    }
}
