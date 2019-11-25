package com.manikanta.dsa.trees.views;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Manikanta Tummalapenta on 24 Nov 2019
 */
public class LeftView {

    // Iterative approach - with Queue
    private void leftView1(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Integer len = q.size();
            System.out.print(q.peek().data + " ");

            for (int i = 0; i < len; i++) {
                Node curr = q.poll();

                if (null != curr.left) {
                    q.add(curr.left);
                }
                if (null != curr.right) {
                    q.add(curr.right);
                }
            }
        }
    }

    // Recursive approach using level
    private static Integer maxLevel = 0;
    private void leftView2(Node root, Integer currLevel) {
        if (null == root) {
            return;
        }

        if (maxLevel < currLevel) {
            System.out.print(root.data + " ");
            maxLevel = currLevel;
        }

        leftView2(root.left, currLevel + 1);
        leftView2(root.right, currLevel + 1);
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();

        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        BinaryTree tree = new BinaryTree(root);

        leftView.leftView1(tree.getRoot());
        System.out.println();

        leftView.leftView2(tree.getRoot(), 1);
        System.out.println();
    }
}
