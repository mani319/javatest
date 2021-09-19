package com.manikanta.dsa.trees.stats;

import com.manikanta.dsa.trees.BinaryTree;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Manikanta Tummalapenta on 18/09/21
 */
public class InOrderPreSucBST {

    public static void inOrderPreSuc(BinaryTree.Node root, int key,
                                     AtomicReference<BinaryTree.Node> pre,
                                     AtomicReference<BinaryTree.Node> suc) {
        if (null == root) {
            return;
        }

        // Biggest in left subtree is predecessor
        // Smallest in right subtree is successor
        if (root.data == key) {

            // Set pre
            if (null != root.left) {
                BinaryTree.Node curr = root.left;
                while (null != curr.right) {
                    curr = curr.right;
                }
                pre.set(curr);
            }

            // Set suc
            if (null != root.right) {
                BinaryTree.Node curr = root.right;
                while (null != curr.left) {
                    curr = curr.left;
                }
                suc.set(curr);
            }

            return;
        }

        // recur and set pre/suc
        if (key > root.data) {
            pre.set(root);
            inOrderPreSuc(root.right, key, pre, suc);
        } else {
            suc.set(root);
            inOrderPreSuc(root.left, key, pre, suc);
        }
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.root = new BinaryTree.Node(4);
        bst.root.left = new BinaryTree.Node(2);
        bst.root.right = new BinaryTree.Node(5);
        bst.root.left.left = new BinaryTree.Node(1);
        bst.root.left.right = new BinaryTree.Node(3);

        AtomicReference<BinaryTree.Node> pre = new AtomicReference<>(null);
        AtomicReference<BinaryTree.Node> suc = new AtomicReference<>(null);
        inOrderPreSuc(bst.root, 3, pre, suc);
        printPreSuc(pre.get(), suc.get());

        pre = new AtomicReference<>(null);
        suc = new AtomicReference<>(null);
        inOrderPreSuc(bst.root, 5, pre, suc);
        printPreSuc(pre.get(), suc.get());

        pre = new AtomicReference<>(null);
        suc = new AtomicReference<>(null);
        inOrderPreSuc(bst.root, 1, pre, suc);
        printPreSuc(pre.get(), suc.get());
    }

    private static void printPreSuc(BinaryTree.Node pre, BinaryTree.Node suc) {
        if (null == pre && null == suc) {
            System.out.println("pre: null, suc: null");
        } else if (null == pre) {
            System.out.println("pre: null, suc: " + suc.data);
        } else if (null == suc) {
            System.out.println("pre: " + pre.data + ", suc: null");
        } else {
            System.out.println("pre: " + pre.data + ", suc: " + suc.data);
        }
    }
}
