package com.manikanta.dsa.trees.paths;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.stream.Stream;

/**
 * Created by Manikanta Tummalapenta on 02 Dec 2019
 */
public class MaxSumPath {

    // Can use static variable instead of this but not recommended
    class Res {
        Integer result;
    }

    private Integer leafToLeafUtil(Node root, Res res) {
        if (null == root) {
            return 0;
        }

        Integer leftSum = leafToLeafUtil(root.left, res);
        Integer rightSum = leafToLeafUtil(root.right, res);

        if (root.isFullParent()) {
            res.result = Math.max(res.result, leftSum + rightSum + root.data);
        }

        return Math.max(leftSum, rightSum) + root.data;
    }

    private Integer anyToAnyNodeUtil(Node root, Res res) {
        if (root == null) {
            return 0;
        }

        Integer leftSum = Math.max(0, anyToAnyNodeUtil(root.left, res));
        Integer rightSum = Math.max(0, anyToAnyNodeUtil(root.right, res));

        res.result = Math.max(res.result, leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }

    // Ref - https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
    private Integer leafToLeaf(Node root) {
        Res res = new Res();
        res.result = Integer.MIN_VALUE;
        leafToLeafUtil(root, res);
        return res.result;
    }

    // Ref - https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
    private Integer anyToAnyNode(Node root) {
        Res res = new Res();
        res.result = Integer.MIN_VALUE;
        anyToAnyNodeUtil(root, res);
        return res.result;
    }

    public static void main(String[] args) {
        MaxSumPath maxSumPath = new MaxSumPath();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        System.out.println("Max pathSum of the given binary tree is "
                + maxSumPath.leafToLeaf(tree.root));

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(10);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(10);
        tree1.root.left.left = new Node(20);
        tree1.root.left.right = new Node(1);
        tree1.root.right.right = new Node(-25);
        tree1.root.right.right.left = new Node(3);
        tree1.root.right.right.right = new Node(4);
        System.out.println("Max pathSum of the given binary tree is "
                + maxSumPath.anyToAnyNode(tree1.root));

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(-1);
        root.left.right = new Node(-4);
        root.right.left = new Node(-5);
        root.right.right = new Node(-6);
        root.left.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(4);
        root.right.left.left.right = new Node(-2);
        System.out.println("Max pathSum of the given binary tree 2 is "
                + maxSumPath.anyToAnyNode(root));
    }
}
