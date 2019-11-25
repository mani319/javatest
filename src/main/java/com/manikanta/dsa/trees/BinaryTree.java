package com.manikanta.dsa.trees;

/**
 * Created by Manikanta Tummalapenta on 24 Nov 2019
 */
public class BinaryTree {

    Node root;

    public static class Node {
        public Integer data;
        public Node left;
        public Node right;
        public Integer hd; // Used for Top and Bottom View
        public Node nextRight;

        public Node(Integer data) {
            this.data = data;
            this.left = this.right = null;
            this.hd = Integer.MAX_VALUE;
            this.nextRight = null;
        }
    }

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
