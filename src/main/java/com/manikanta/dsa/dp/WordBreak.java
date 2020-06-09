package com.manikanta.dsa.dp;

import com.manikanta.dsa.MiscUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        if (0 == s.length()) {
            return true;
        }

        dp[0] = wordDict.contains(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }

            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("mobile", "samsung", "sam",
                "sung", "man", "mango",
                "icecream", "and", "go",
                "i", "like", "ice", "cream"));

        List<String> s = new ArrayList<>(Arrays.asList("ilikesamsung", "iiiiiiii", "",
                "ilikelikeimangoiii", "samsungandmango", "samsungandmangok"));

        for (String value : s) {
            System.out.println(wordBreak(value, wordDict));
        }
    }
}
