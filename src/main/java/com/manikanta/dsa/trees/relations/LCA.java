package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 27 Nov 2019
 */
public class LCA {

    // These are required in the case where it is not sure n1 and n2 always exist
    static boolean n1Exists = false, n2Exists = false;
    private Node findLCA(Node root, Integer n1, Integer n2) {

        // This is because we are running multiple test cases
        n1Exists = false; n2Exists = false;

        Node lca = LCAUtil(root, n1, n2);

        if (n1Exists && n2Exists)
            return lca;

        return null;
    }

    private Node LCAUtil(Node root, Integer n1, Integer n2) {
        if (null == root)
            return null;

        Node temp = null;
        if (n1 == root.data) {
            n1Exists = true;
            temp = root;
        }
        if (n2 == root.data) {
            n2Exists = true;
            temp = root;
        }

        Node leftLCA = LCAUtil(root.left, n1, n2);
        Node rightLCA = LCAUtil(root.right, n1, n2);

        if (null != temp)
            return temp;

        if (null != leftLCA && null != rightLCA)
            return root;

        return null != leftLCA ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        LCA lca = new LCA();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node node = lca.findLCA(tree.root, 4, 5);
        if (node != null)
            System.out.println("LCA(4, 5) = " + node.data);
        else
            System.out.println("Keys are not present");

        node = lca.findLCA(tree.root, 4, 10);
        if (node != null)
            System.out.println("LCA(4, 10) = " + node.data);
        else
            System.out.println("Keys are not present");

        node = lca.findLCA(tree.root, 8, 10);
        if (node != null)
            System.out.println("LCA(4, 10) = " + node.data);
        else
            System.out.println("Keys are not present");
    }
}
