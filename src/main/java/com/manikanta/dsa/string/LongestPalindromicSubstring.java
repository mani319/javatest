package com.manikanta.dsa.string;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 14 May 2020
 */
public class LongestPalindromicSubstring {

    private static String longestPalindromicSubstring(String str) {
        int n = str.length();
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // Find odd length
            int oddLen = getPalindromeLength(str, i, i, n);

            // Find even length
            int evenLen = getPalindromeLength(str, i, i + 1, n);

            int maxLength = Math.max(oddLen, evenLen);
            if (maxLength > end - start) {
                start = i - ((maxLength - 1) / 2);
                end = i + maxLength / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private static int getPalindromeLength(String str, int left, int right, int n) {
        while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        Assert.assertEquals("dfghgfd", longestPalindromicSubstring("awsdfghgfduidkown"));
        Assert.assertEquals("geeksskeeg", longestPalindromicSubstring("trggeeksskeegwf"));
        Assert.assertEquals("l", longestPalindromicSubstring("asdfghjkl"));
    }
}
