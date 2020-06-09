package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree.Node;
import com.manikanta.dsa.trees.stats.LevelOfNode;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class PrintAllCousins {

    static void printCousins(Node root, Node node) {
        // Go and check this implementation
        Integer nodeLevel = LevelOfNode.levelOfNode(root, node);

        printCousinsAtGivenLevel(root, node, nodeLevel);
    }

    private static void printCousinsAtGivenLevel(Node root, Node node, Integer nodeLevel) {
        if (null == node || nodeLevel < 2) {
            return;
        }

        if (2 == nodeLevel) {
            if (node == root.left || node == root.right) {
                return;
            }
            if (null != root.left) {
                System.out.print(root.left.data + " ");
            }
            if (null != root.right) {
                System.out.print(root.right.data + " ");
            }

            return;
        }

        printCousinsAtGivenLevel(root.left, node, nodeLevel - 1);
        printCousinsAtGivenLevel(root.right, node, nodeLevel - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        printCousins(root, root.left.left);
    }
}
