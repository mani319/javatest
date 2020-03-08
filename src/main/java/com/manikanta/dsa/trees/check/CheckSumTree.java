package com.manikanta.dsa.trees.check;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class CheckSumTree {

    // Ref - https://www.techiedelight.com/check-given-binary-tree-sum-tree-not/
    static Integer isSumTree(Node root) {
        if (null == root) {
            return 0;
        }
        if (root.isLeafNode()) {
            return root.data;
        }

        if (root.data == isSumTree(root.left) + isSumTree(root.right)) {
            return 2 * root.data;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(27);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);

        if (isSumTree(tree.root) != Integer.MIN_VALUE) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
