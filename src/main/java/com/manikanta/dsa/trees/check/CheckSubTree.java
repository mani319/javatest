package com.manikanta.dsa.trees.check;

import com.manikanta.dsa.trees.BinaryTree.Node;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Manikanta Tummalapenta on 23 Apr 2020
 */
public class CheckSubTree {
    // Function to store in-order traversal of the tree in a list
    private static void inorder(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    // Function to store post-order traversal of the tree in a list
    private static void postorder(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node);
    }

    // Function to check if given binary tree is a subtree of another
    // binary tree or not
    private static boolean checkSubtree(Node tree, Node subtree) {
        if (tree == subtree) {
            return true;
        }

        if (tree == null) {
            return false;
        }

        List<Node> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);

        if (first.toString().contains(second.toString())) {
            return false;
        }

        // reset both lists
        first.clear();
        second.clear();

        postorder(tree, first);
        postorder(subtree, second);

        if (first.toString().contains(second.toString())) {
            return false;
        }

        return true;
    }

    // main function
    public static void main(String[] args) {
	    /* Construct below tree
		          1
		       /     \
		      2       3
		     / \     / \
		    4   5   6   7
	    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node root2 = new Node(2);
        root2.left = new Node(4);
        root2.right = new Node(6);

        Assert.assertEquals(true, checkSubtree(root, root.right));
        Assert.assertEquals(true, checkSubtree(root, null));

        // TODO: This case is failing. Need to recheck implementation
        Assert.assertEquals(false, checkSubtree(root, root2));
    }
}
