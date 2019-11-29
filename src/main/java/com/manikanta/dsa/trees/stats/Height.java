package com.manikanta.dsa.trees.stats;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 29 Nov 2019
 */
public class Height {

    public static Integer height(Node root) {
        if (null == root) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        Height height = new Height();
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(5);

        System.out.println("Height of tree is : " +
                height.height(tree.root));
    }
}
