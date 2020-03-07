package com.manikanta.dsa.trees.convert;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 05 Dec 2019
 */
public class ConvertToMirrorTree {

    private void convert(Node root) {
        if (null == root || root.isLeafNode()) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        convert(root.left);
        convert(root.right);
    }

    public static void main(String[] args) {
        ConvertToMirrorTree convertToMirrorTree = new ConvertToMirrorTree();

        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        BinaryTree.inOrder(tree.getRoot());
        System.out.println("");

        /* convert tree to its mirror */
        convertToMirrorTree.convert(tree.getRoot());

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        BinaryTree.inOrder(tree.getRoot());
    }
}
