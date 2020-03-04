package com.manikanta.dsa.backtracking;

/**
 * Created by Manikanta Tummalapenta on 26 Feb 2020
 */
public class KnightTour {

    private static int N = 6;

    private static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }

    private static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    private static boolean solveKTUtil(int x, int y, int move,
                                       int sol[][], int xMove[],
                                       int yMove[]) {
        int k, next_x, next_y;
        if (move == N * N)
            return true;

        if (isSafe(x, y, sol)) {
            sol[x][y] = move;

            // Try all next moves from the current coordinate x, y
            for (k = 0; k < 8; k++) {
                next_x = x + xMove[k];
                next_y = y + yMove[k];
                if (solveKTUtil(next_x, next_y, move + 1,
                        sol, xMove, yMove)) {
                    return true;
                }
            }

            sol[x][y] = -1;
            return false;
        }

        return false;
    }

    private static boolean solveKT() {
        int sol[][] = new int[N][N];

        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!solveKTUtil(0, 0, 0, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }

        return true;
    }

    public static void main(String[] args) {
        solveKT();
    }
}
