package com.manikanta.dsa.matrix;

/**
 * Created by Manikanta Tummalapenta on 25/09/21
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];

        int max = 0;
        // Fill first column
        for (int i = 0; i < height; i++) {
            dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
            max = Math.max(max, dp[i][0]);
        }

        // Fill first row
        for (int j = 0; j < width; j++) {
            dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
            max = Math.max(max, dp[0][j]);
        }

        // Fill remaining - check min(left, up, leftuppercorner)
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {

                if (matrix[i][j] == '1') {
                    dp[i][j] = minOf3(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

    private static int minOf3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
