package com.manikanta.dsa.dp.strings;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 08 Feb 2020
 *
 * Ref - http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 */
public class LongestPalindromicSubstring {

    // NOTE: There is a O(n^2), O(1) solution possible with Expand Around Center
    // NOTE: There is a O(n), O(n) solution possible with Manacher's Algorithm
    // All other solutions: https://leetcode.com/problems/longest-palindromic-substring/solution/


    // DP - O(n^2) time and space
    private static String longestPalSubstr(String str) {
        int n = str.length();
        if (0 == n) {
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // First initialize dp[i][i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    if (l == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && l > maxLen) {
                    start = i;
                    maxLen = l;
                }
            }
        }

        return str.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        Assert.assertEquals("geeksskeeg", longestPalSubstr(str));

        str = "babad";
        Assert.assertEquals("bab", longestPalSubstr(str));

        str = "cbbd";
        Assert.assertEquals("bb", longestPalSubstr(str));

        str = "a";
        Assert.assertEquals("a", longestPalSubstr(str));

        str = "";
        Assert.assertEquals("", longestPalSubstr(str));

        str = "bb";
        Assert.assertEquals("bb", longestPalSubstr(str));

        str = "ccc";
        Assert.assertEquals("ccc", longestPalSubstr(str));
    }
}
