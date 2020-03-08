package com.manikanta.dsa.trees.check;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

/**
 * Created by Manikanta Tummalapenta on 07 Mar 2020
 */
public class CheckHeightBalanced {

    static class Height {
        int height = 0;
    }

    static boolean isBalanced(Node root, Height h) {
        if (null == root) {
            h.height = 0;
            return true;
        }

        Height lh = new Height(), rh = new Height();

        boolean leftBalanced = isBalanced(root.left, lh);
        boolean rightBalanced = isBalanced(root.right, rh);

        int leftHeight = lh.height, rightHeight = rh.height;

        h.height = Math.max(leftHeight, rightHeight) + 1;

        return leftBalanced
                && rightBalanced
                && (Math.abs(leftHeight - rightHeight) < 2);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (isBalanced(tree.root, new Height()))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");


        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.right.right = new Node(6);
        tree2.root.left.left.left = new Node(7);

        if (isBalanced(tree2.root, new Height()))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
