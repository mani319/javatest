package com.manikanta.dsa.trees.convert;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 04 Mar 2020
 */
public class ConvertToDLL {

    private static Node head = null;
    private static Node prev = null;

    // Method - 1
    private static void usingInOrderTraversal(Node root) {
        if (null == root) {
            return;
        }

        usingInOrderTraversal(root.left);

        if (null == prev) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        usingInOrderTraversal(root.right);
    }

    // Method - 2
    private static void usingReverseInOrderTraversal(Node root) {
        if (null == root) {
            return;
        }

        usingReverseInOrderTraversal(root.right);

        root.right = head;
        if (null != head) {
            head.left = root;
        }
        head = root;

        usingReverseInOrderTraversal(root.left);
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // Just to make sure these are reset before input
        head = null;
        prev = null;

        // convert to DLL
        usingInOrderTraversal(tree.root);

        // Print the converted List
        printList(head);

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(10);
        tree1.root.left = new Node(12);
        tree1.root.right = new Node(15);
        tree1.root.left.left = new Node(25);
        tree1.root.left.right = new Node(30);
        tree1.root.right.left = new Node(36);

        // Just to make sure these are reset before input
        head = null;
        prev = null;

        // convert to DLL
        usingReverseInOrderTraversal(tree1.root);

        // Print the converted List
        printList(head);
    }
}
