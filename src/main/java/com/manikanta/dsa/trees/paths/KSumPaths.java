package com.manikanta.dsa.trees.paths;

import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 07 Mar 2020
 */
public class KSumPaths {

    private static void rootToLeafPathsUtil(Node root, List<List<Integer>> result,
                                            List<Integer> currNodes, int sum) {
        if (null == root) {
            return;
        }

        currNodes.add(root.data);

        if (root.isLeafNode()) {
            if (0 == sum - root.data) {
                result.add(new LinkedList<>(currNodes));
            }
        } else {
            rootToLeafPathsUtil(root.left, result, currNodes, sum - root.data);
            rootToLeafPathsUtil(root.right, result, currNodes, sum - root.data);
        }

        // Back tracking move
        currNodes.remove(currNodes.size() - 1);
    }

    private static void rootToAnyPathsUtil(Node root, List<List<Integer>> result,
                                           List<Integer> currNodes, int sum) {
        if (null == root) {
            return;
        }

        currNodes.add(root.data);

        if (0 == sum - root.data) {
            result.add(new LinkedList<>(currNodes));
        } else {
            rootToAnyPathsUtil(root.left, result, currNodes, sum - root.data);
            rootToAnyPathsUtil(root.right, result, currNodes, sum - root.data);
        }

        // Back tracking move
        currNodes.remove(currNodes.size() - 1);
    }

    // Ref - https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
    private static void anyToAnyPathsUtil(Node root, List<List<Integer>> result,
                                           List<Integer> currNodes, int sum) {
        if (null == root) {
            return;
        }

        currNodes.add(root.data);

        int sumEndingAtThisNode = 0;
        for (int i = currNodes.size() - 1; i >= 0; i--) {
            sumEndingAtThisNode += currNodes.get(i);

            if (sumEndingAtThisNode == sum) {
                result.add(new LinkedList<>(currNodes.subList(i, currNodes.size())));
            }
        }

        anyToAnyPathsUtil(root.left, result, currNodes, sum);
        anyToAnyPathsUtil(root.right, result, currNodes, sum);

        // Back tracking move
        currNodes.remove(currNodes.size() - 1);
    }

    public static void rootToLeafPaths(Node root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currNodes = new ArrayList<>();

        rootToLeafPathsUtil(root, result, currNodes, sum);

        System.out.println(result);
    }

    public static void rootToAnyPaths(Node root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currNodes = new ArrayList<>();

        rootToAnyPathsUtil(root, result, currNodes, sum);

        System.out.println(result);
    }

    public static void anyToAnyPaths(Node root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currNodes = new ArrayList<>();

        anyToAnyPathsUtil(root, result, currNodes, sum);

        System.out.println(result);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        rootToLeafPaths(root, k);
        rootToAnyPaths(root, k);
        anyToAnyPaths(root, k);
    }
}
