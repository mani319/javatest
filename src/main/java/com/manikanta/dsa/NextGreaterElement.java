package com.manikanta.dsa;

import java.util.Stack;

/**
 * Created by Manikanta Tummalapenta on 21 Dec 2019
 */
public class NextGreaterElement {

    private void findNGE(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < a[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                System.out.println(a[i] + " --> " + stack.peek());
            } else {
                System.out.println(a[i] + " --> " + -1);
            }

            stack.push(a[i]);
        }
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();

        int arr[]= {11, 13, 21, 3};
        int n = arr.length;
        nge.findNGE(arr, n);
    }
}
