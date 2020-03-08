package com.manikanta.dsa.trees.convert;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class ConvertToSumTree {

    // Ref - https://www.techiedelight.com/inplace-convert-a-tree-sum-tree/
    static int convertToSumTree(Node root) {
        if (null == root) {
            return 0;
        }

        int leftSum = convertToSumTree(root.left);
        int rightSum = convertToSumTree(root.right);

        int oldVlaue = root.data;

        root.data = leftSum + rightSum;

        return root.data + oldVlaue;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        convertToSumTree(root);
        BinaryTree.inOrder(root);
    }
}
