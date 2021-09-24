package com.manikanta.dsa.string.slidingwindow;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
public class LongSubstrWithoutRepeating {

    public static String findLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int resultStart = 0, resultEnd = 0;
        int[] charCount = new int[128];

        for (int start = 0, end = 0; end < s.length(); end++) {
            charCount[s.charAt(end)]++;

            while (charCount[s.charAt(end)] > 1) {
                charCount[s.charAt(start)]--;
                start++;
            }

            if (end - start > resultEnd - resultStart) {
                resultStart = start;
                resultEnd = end;
            }
        }

        return s.substring(resultStart, resultEnd + 1);
    }

    public static void main(String[] args) {
        Assert.assertEquals("abc", findLongestSubstring("abcabcbb"));
        Assert.assertEquals("b", findLongestSubstring("bbbbb"));
        Assert.assertEquals("wke", findLongestSubstring("pwwkew"));
        Assert.assertEquals("", findLongestSubstring(""));
        Assert.assertEquals("dlongest", findLongestSubstring("findlongestsubstring"));
        Assert.assertEquals("longest", findLongestSubstring("longestsubstr"));
        Assert.assertEquals("bcdafe", findLongestSubstring("abbcdafeegh"));
    }
}
