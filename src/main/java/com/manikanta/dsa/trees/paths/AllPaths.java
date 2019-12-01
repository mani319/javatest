package com.manikanta.dsa.trees.paths;

import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 01 Dec 2019
 */
public class AllPaths {

    private void printAllPaths(Node root, Integer arr[], Integer pathLen) {
        if (null == root) {
            return;
        }

        arr[pathLen] = root.data;
        pathLen++;

        if (null == root.left && null == root.right) {
            printArray(arr, pathLen);
            return;
        }

        printAllPaths(root.left, arr, pathLen);
        printAllPaths(root.right, arr, pathLen);
    }

    private void printArray(Integer ints[], Integer len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        AllPaths allPaths = new AllPaths();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        allPaths.printAllPaths(root, new Integer[1000], 0);

        System.out.println("**************");

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.left = new Node(5);
        root1.left.right.right = new Node(6);
        root1.right = new Node(7);
        root1.right.right = new Node(8);
        root1.right.right.right = new Node(9);
        root1.right.right.right.left = new Node(10);
        root1.right.right.right.left.left = new Node(11);
        root1.right.right.right.left.right = new Node(12);
        root1.right.right.right.right = new Node(13);

        allPaths.printAllPaths(root1, new Integer[1000], 0);
    }
}
