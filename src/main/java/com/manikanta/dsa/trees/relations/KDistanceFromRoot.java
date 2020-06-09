package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class KDistanceFromRoot {
    
    static void nodesAtKDistanceDownwards(Node root, Integer k) {
        if (null == root) {
            return;
        }

        if (0 == k) {
            System.out.print(root.data + " ");
            return;
        }

        nodesAtKDistanceDownwards(root.left, k - 1);
        nodesAtKDistanceDownwards(root.right, k - 1);
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

        nodesAtKDistanceDownwards(tree.root, 2);
    }
}
