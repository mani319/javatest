package com.manikanta.dsa.trees.traversals;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.Stack;

/**
 * Created by Manikanta Tummalapenta on 11 Jan 2020
 */
public class InOrderTraversal {
    
    void iterative(Node root) {
        Stack<Node> s = new Stack<>();
        Node node = root;

        while (node != null || !s.isEmpty()) {

            while (node != null) {
                s.push(node);
                node = node.left;
            }

            node = s.pop();
            System.out.print(node.data + " ");

            node = node.right;
        }
    }

    public static void recursive(Node root) {
        if (null == root) {
            return;
        }

        recursive(root.left);
        System.out.print(root.data + " ");
        recursive(root.right);
    }

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        System.out.print("Iterative: ");
        inOrderTraversal.iterative(tree.getRoot());
        System.out.println();
        System.out.print("Recursive: ");
        inOrderTraversal.recursive(tree.getRoot());
    }
}
