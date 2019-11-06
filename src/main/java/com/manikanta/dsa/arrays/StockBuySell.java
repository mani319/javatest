package com.manikanta.dsa.arrays;

/**
 * Created by Manikanta Tummalapenta on 06 Nov 2019
 */
public class StockBuySell {

    private void stockBuySell(int arr[]) {
        int start = 0, end, n = arr.length;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1] || i == n-1) {
                if (arr[i] < arr[i-1]) {
                    end = i - 1;
                } else {
                    end = i;
                }

                if (start != end) {
                    System.out.println(start + " " + end);
                    flag = true;
                }
                start = i;
            }
        }

        if (!flag) {
            System.out.println("No profit!");
        }
    }

    public static void main(String[] args) {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };

        stock.stockBuySell(price);
        System.out.println("------------------");

        int price2[] = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        stock.stockBuySell(price2);
        System.out.println("------------------");

        int price3[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        stock.stockBuySell(price3);
        System.out.println("------------------");
    }
}
