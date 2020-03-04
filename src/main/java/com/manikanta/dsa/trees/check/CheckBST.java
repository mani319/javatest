package com.manikanta.dsa.trees.check;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 27 Nov 2019
 */
public class CheckBST {

    private boolean isBST1(Node root, Node l, Node r) {

        // IMP:- Observe the recursion conditions
        // This traverses down the tree keeping track of the
        // narrowing min and max allowed values as it goes, looking at each node only once.
        return null == root ||
                (null == l || l.data < root.data) &&
                (null == r || r.data > root.data) &&
                isBST1(root.left, l, root) &&
                isBST1(root.right, root, r);
    }

    private Node prev = null;
    private boolean isBST2(Node root) {
        // This is useful in case of multiple test cases
        prev = null;

        return isBST2Util(root);
    }

    // Inorder order traversal with prev node
    private boolean isBST2Util(Node root) {
        if (null == root)
            return true;

        if (!isBST2Util(root.left))
            return false;

        if (null != prev && prev.data >= root.data)
            return false;
        prev = root;

        return isBST2Util(root.right);
    }

    public static void main(String[] args) {
        CheckBST checkBST = new CheckBST();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(4);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(5);
        tree2.root.left.left = new Node(1);
        tree2.root.left.right = new Node(3);

        if (checkBST.isBST1(tree.getRoot(), null, null))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");

        if (checkBST.isBST2(tree.getRoot()))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

        if (checkBST.isBST1(tree2.getRoot(), null, null))
            System.out.println("Is BST");
        else
            System.out.println("Not a BST");

        if (checkBST.isBST2(tree2.getRoot()))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
