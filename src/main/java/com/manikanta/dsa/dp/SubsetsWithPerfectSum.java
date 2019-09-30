package com.manikanta.dsa.dp;

import java.util.ArrayList;

/**
 * Created by Manikanta Tummalapenta on 18 Mar 2019
 */
public class SubsetsWithPerfectSum {

    private static boolean[][] dp;


    private static void printSubsets(int arr[], int n, int sum) {

        dp = new boolean[n][sum + 1];

        // 0 sum can be achieved with any number of elements
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Sum arr[0] can be achieved with single element
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {

                dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i-1][j - arr[i]]) : dp[i - 1][j];
            }
        }

        printDPArray(n, sum);

        // To find whether exact sum can be extracted or not - get dp[n-1][sum]
        if (dp[n-1][sum]) {
            System.out.println("Exact sum can be found");
            ArrayList<Integer> p = new ArrayList<>();
            printSubsetsRec(arr, n-1, sum, p);
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
        if (arr[i] <= sum && dp[i - 1][sum - arr[i]]) {
            p.add(arr[i]);
            printSubsetsRec(arr, i-1, sum - arr[i], p);
        }
    }


    private static void printDPArray(int n, int sum) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int length = arr.length;
        int sum = 10;
        printSubsets(arr, length, sum);
    }
}
