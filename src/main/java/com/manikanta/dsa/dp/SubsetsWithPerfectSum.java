package com.manikanta.dsa.dp;

import java.util.ArrayList;

/**
 * Created by Manikanta Tummalapenta on 18 Mar 2019
 */
public class SubsetsWithPerfectSum {

    private static boolean[][] dp;


    private static void printSubsets(int arr[], int n, int sum) {

        dp = new boolean[n+1][sum + 1];

        // Nothing can be achieved using 0 elements
        for (int j = 0; j < sum+1; j++) {
            dp[0][j] = false;
        }

        // 0 sum can be achieved with any number of elements
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {

                dp[i][j] = (arr[i-1] <= j)
                        ? dp[i - 1][j] || dp[i-1][j - arr[i-1]]
                        : dp[i - 1][j];
            }
        }

        // To find whether exact sum can be extracted or not - get dp[n][sum]
        if (dp[n][sum]) {
            System.out.println("Exact sum can be found");
            ArrayList<Integer> p = new ArrayList<>();
            printSubsetsRec(arr, n, sum, p);
        } else {
            System.out.println("Exact sum can't be found :( ");
        }
    }


    private static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) {

        // Reached top row and sum is 0
        if (i == 0 && sum == 0) {
            System.out.println(p);
            p.clear();
            return;
        }

        // Reached top row but sum is non zero and element value is sum
        if (i == 0 && dp[0][sum]) {
            p.add(arr[i]);
            System.out.println(p);
            p.clear();
            return;
        }

        // Sum is reached after ignoring element - Got to previous row one with same sum
        if (dp[i-1][sum]) {
            ArrayList<Integer> b = new ArrayList<>(p);
            printSubsetsRec(arr, i-1, sum, b);
        }

        // Sum is reached after including this element - Got to previous row by decreasing current element value
        if (arr[i-1] <= sum && dp[i-1][sum-arr[i-1]]) {
            p.add(arr[i-1]);
            printSubsetsRec(arr, i-1, sum-arr[i-1], p);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int length = arr.length;
        int sum = 10;
        printSubsets(arr, length, sum);
    }
}
