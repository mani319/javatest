package com.manikanta.dsa.trees.stats;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 08 Mar 2020
 */
public class LevelOfNode {
    
    public static int levelOfNode(Node root, Node node) {
        return levelOfNode(root, node, 1);
    }

    static int levelOfNode(Node root, Node node, Integer level) {
        if (null == root) {
            return 0;
        }

        if (root == node) {
            return level;
        }

        // If node is present in left subtree
        Integer nodeLevel = levelOfNode(root.left, node, level + 1);
        if (nodeLevel != 0) {
            return nodeLevel;
        }

        // If node is not present in left subtree
        return levelOfNode(root.right, node, level + 1);
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

        System.out.println(levelOfNode(tree.root, tree.root.left.left));
    }
}
