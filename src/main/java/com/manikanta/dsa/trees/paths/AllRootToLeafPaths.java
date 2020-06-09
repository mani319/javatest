package com.manikanta.dsa.trees.paths;

import com.manikanta.dsa.trees.BinaryTree.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Manikanta Tummalapenta on 01 Dec 2019
 */
public class AllRootToLeafPaths {

    private void printAllPaths(Node root, Integer arr[], Integer pathLen) {
        if (null == root) {
            return;
        }

        arr[pathLen] = root.data;
        pathLen++;

        if (root.isLeafNode()) {
            printArray(arr, pathLen);
            return;
        }

        printAllPaths(root.left, arr, pathLen);
        printAllPaths(root.right, arr, pathLen);
    }

    // Backtracking Approach - Will be useful in other path examples
    private void printAllPaths2(Node root, List<Integer> currNodes) {
        if (null == root) {
            return;
        }

        currNodes.add(root.data);

        if (root.isLeafNode()) {
            System.out.println(currNodes);
        } else {
            printAllPaths2(root.left, currNodes);
            printAllPaths2(root.right, currNodes);
        }

        // Back tracking move
        currNodes.remove(currNodes.size() - 1);
    }

    private void printArray(Integer ints[], Integer len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        AllRootToLeafPaths allRootToLeafPaths = new AllRootToLeafPaths();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        allRootToLeafPaths.printAllPaths(root, new Integer[1000], 0);
        allRootToLeafPaths.printAllPaths2(root, new ArrayList<>());

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

        allRootToLeafPaths.printAllPaths(root1, new Integer[1000], 0);
        allRootToLeafPaths.printAllPaths2(root1, new ArrayList<>());
    }
}
