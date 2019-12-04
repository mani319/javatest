package com.manikanta.dsa.matrix;

/**
 * Created by Manikanta Tummalapenta on 04 Dec 2019
 */
public class Islands {

    // Ref - https://www.geeksforgeeks.org/count-number-islands-every-island-separated-line/
    private Integer getRowColumnSeparatedIslands(int[][] mat, int m, int n) {
        Integer noOfIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ('X' == mat[i][j]) {
                    if ((0 == i || 'O' == mat[i-1][j]) &&
                            (0 == j || 'O' == mat[i][j-1])) {

                        noOfIslands++;
                    }
                }
            }
        }

        return noOfIslands;
    }

    // Ref - https://www.geeksforgeeks.org/find-number-of-islands/ - DFS
    private Integer findNumberOfIslands(int[][] mat, int m, int n) {
        Integer noOfIslands = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (1 == mat[i][j] && !visited[i][j]) {
                    findIslandsUtil(mat, i, j, visited);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void findIslandsUtil(int[][] mat, int i, int j, boolean[][] visited) {
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[i][j] = true;

        for (int k = 0; k < rowNbr.length; k++) {
            if (isSafe(mat, i + rowNbr[k], j + colNbr[k], visited)) {
                findIslandsUtil(mat, i + rowNbr[k], j + colNbr[k], visited);
            }
        }
    }

    private boolean isSafe(int[][] mat, int i, int j, boolean[][] visited) {
        return (i >= 0 && i < mat.length) &&
                (j >= 0 && j < mat[0].length) &&
                1 == mat[i][j] &&
                !visited[i][j];
    }

    public static void main(String[] args) {
        Islands islands = new Islands();

        int m = 6;
        int n = 3;
        int mat[][] = {{'O', 'O', 'O'},
                {'X', 'X', 'O'},
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'}
        };
        System.out.println("Number of rectangular islands is: "
                + islands.getRowColumnSeparatedIslands(mat, m, n));

        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println("Number of islands is: " + islands.findNumberOfIslands(M, M.length, M[0].length));
    }
}
