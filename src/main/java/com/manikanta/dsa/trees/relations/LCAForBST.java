package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree;

/**
 * Created by Manikanta Tummalapenta on 18/09/21
 */
public class LCAForBST {

    static BinaryTree.Node lca(BinaryTree.Node root, BinaryTree.Node n1, BinaryTree.Node n2) {
        if (null == root) {
            return null;
        }
        if (n1 == root || n2 == root) {
            return root;
        }

        if (n1.data < root.data && n2.data < root.data) {
            return lca(root.left, n1, n2);
        }
        if (n1.data > root.data && n2.data > root.data) {
            return lca(root.right, n1, n2);
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.root = new BinaryTree.Node(4);
        bst.root.left = new BinaryTree.Node(2);
        bst.root.right = new BinaryTree.Node(5);
        bst.root.left.left = new BinaryTree.Node(1);
        bst.root.left.right = new BinaryTree.Node(3);

        BinaryTree.Node lca = lca(bst.root, bst.root.left.left, bst.root.right);
        System.out.println("lca is " + lca.data);

        BinaryTree.Node lca1 = lca(bst.root, bst.root.left, bst.root.left.right);
        System.out.println("lca1 is " + lca1.data);

        BinaryTree.Node lca2 = lca(bst.root, bst.root.left.left, bst.root.left.right);
        System.out.println("lca2 is " + lca2.data);
    }
}
