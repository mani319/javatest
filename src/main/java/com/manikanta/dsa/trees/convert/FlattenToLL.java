package com.manikanta.dsa.trees.convert;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 04 Mar 2020
 *
 * Ref - https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
 */
public class FlattenToLL {

    private static void flattenTreeToLL(Node root) {

        if (null == root || root.isLeafNode()) {
            return;
        }

        flattenTreeToLL(root.right);

        if (null != root.left) {
            flattenTreeToLL(root.left);

            Node tempRight = root.right;
            root.right = root.left;
            root.left = null;

            Node temp = root.right;
            while (null != temp.right) {
                temp = temp.right;
            }
            temp.right = tempRight;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

        flattenTreeToLL(tree.getRoot());
        BinaryTree.inOrder(tree.getRoot());
        System.out.println();

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(3);
        tree2.root.right = new Node(4);
        tree2.root.right.left = new Node(2);
        tree2.root.right.right = new Node(5);

        flattenTreeToLL(tree2.getRoot());
        BinaryTree.inOrder(tree2.getRoot());
    }
}
