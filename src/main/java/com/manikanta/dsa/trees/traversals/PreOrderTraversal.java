package com.manikanta.dsa.trees.traversals;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.Stack;

/**
 * Created by Manikanta Tummalapenta on 11 Jan 2020
 */
public class PreOrderTraversal {

    void iterative(Node root) {
        if (null == root) {
            return;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node.data + " ");

            // Push right first to make sure right gets executed after left
            if (null != node.right) {
                s.push(node.right);
            }

            if (null != node.left) {
                s.push(node.left);
            }
        }
    }

    public static void recursive(Node root) {
        if (null == root) {
            return;
        }

        System.out.print(root.data + " ");
        recursive(root.left);
        recursive(root.right);
    }

    public static void main(String[] args) {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Iterative: ");
        preOrderTraversal.iterative(tree.getRoot());
        System.out.println();
        System.out.print("Recursive: ");
        preOrderTraversal.recursive(tree.getRoot());
    }
}
