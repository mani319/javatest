package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 07 Mar 2020
 */
public class KDistanceFromNode {

    private static Integer printKDistanceNodes(Node root, Node target, Integer k) {
        if (null == root) {
            return -1;
        }

        if (target == root) {
            KDistanceFromRoot.nodesAtKDistanceDownwards(root, k);
            return 0;
        }

        int leftDist = printKDistanceNodes(root.left, target, k);
        if (-1 != leftDist) {

            if (1 + leftDist == k) {
                System.out.print(root.data + " ");
            } else {
                KDistanceFromRoot.nodesAtKDistanceDownwards(root.right, k - leftDist - 2);
            }

            return 1 + leftDist;
        }

        int rightDist = printKDistanceNodes(root.right, target, k);
        if (-1 != rightDist) {

            if (1 + rightDist == k) {
                System.out.print(root.data + " ");
            } else {
                KDistanceFromRoot.nodesAtKDistanceDownwards(root.left, k - rightDist - 2);
            }

            return 1 + rightDist;
        }

        return -1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;

        printKDistanceNodes(tree.root, target, 2);
    }
}
