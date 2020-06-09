package com.manikanta.dsa.trees.relations;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Manikanta Tummalapenta on 25 Nov 2019
 */
public class ConnectSameLevel {

    // This uses O(n) extra space
    private void connect1(Node root) {
        if (null == root) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev;

        while (!q.isEmpty()) {
            Integer len = q.size();
            System.out.print(q.peek().data + " ");
            prev = null;

            for (int i = 0; i < len; i++) {
                Node curr = q.poll();

                if (null == prev) {
                    prev = curr;
                } else {
                    prev.nextRight = curr;
                }

                if (null != curr.left) {
                    q.add(curr.left);
                }
                if (null != curr.right) {
                    q.add(curr.right);
                }
            }
        }
    }

    // This uses constant extra space
    private void connect2(Node root) {
        if (null == root) {
            return;
        }

        root.nextRight = null;

        while (null != root) {
            Node temp = root;

            while (null != temp) {

                if (null != temp.left) {
                    if (null == temp.right)
                        temp.left.nextRight = getNextRight(temp);
                    else
                        temp.left.nextRight = temp.right;
                }

                if (null != temp.right)
                    temp.right.nextRight = getNextRight(temp);

                temp = temp.nextRight;
            }

            // Next iteration move
            if (null != root.left)
                root = root.left;
            else if (null != root.right)
                root = root.right;
            else
                root = getNextRight(root);
        }
    }

    // This gives the nextRight of current node child's nextRight
    // This should be used for right child always but for left child when right child is not present
    private Node getNextRight(Node a) {
        Node temp = a.nextRight;

        while (null != temp) {
            if (null != temp.left)
                return temp.left;
            if (null != temp.right)
                return temp.right;

            temp = temp.nextRight;
        }

        return null;
    }

    public static void main(String[] args) {
        ConnectSameLevel connectSameLevel = new ConnectSameLevel();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.right.right = new Node(90);

        // Populates nextRight pointer in all nodes
        connectSameLevel.connect1(tree.root);

        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null ?
                tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ?
                tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ?
                tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ?
                tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ?
                tree.root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data
                + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data +
                " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data +
                " is " + e);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(10);
        tree2.root.left = new Node(8);
        tree2.root.right = new Node(2);
        tree2.root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes
        connectSameLevel.connect2(tree2.root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a2 = tree2.root.nextRight != null ? tree2.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree2.root.data + " is "
                + a2);
        int b2 = tree2.root.left.nextRight != null ?
                tree2.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree2.root.left.data + " is "
                + b2);
        int c2 = tree2.root.right.nextRight != null ?
                tree2.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree2.root.right.data + " is "
                + c2);
        int d2 = tree2.root.left.left.nextRight != null ?
                tree2.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree2.root.left.left.data + " is "
                + d2);
    }
}
