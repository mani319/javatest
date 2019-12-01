package com.manikanta.dsa.trees.paths;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 02 Dec 2019
 */
public class MaxPathSum {

    // Can use static variable instead of this but not recommended
    class Res {
        Integer result;
    }

    // Ref - https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
    private Integer leafToLeaf(Node root) {
        Res res = new Res();
        res.result = Integer.MIN_VALUE;
        leafToLeafUtil(root, res);
        return res.result;
    }

    private Integer leafToLeafUtil(Node root, Res res) {
        if (null == root) {
            return 0;
        }
        if (root.isLeafNode()) {
            return root.data;
        }

        Integer leftSum = leafToLeafUtil(root.left, res);
        Integer rightSum = leafToLeafUtil(root.right, res);

        if (root.isFullParent()) {
            res.result = Math.max(res.result, leftSum + rightSum + root.data);
            return Math.max(leftSum, rightSum) + root.data;
        }

        return root.left == null ? rightSum + root.data : leftSum + root.data;
    }

    private void anyToAnyNode() {

    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();

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
                + maxPathSum.leafToLeaf(tree.root));
    }
}
