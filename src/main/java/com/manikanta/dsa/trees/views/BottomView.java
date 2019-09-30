package com.manikanta.dsa.trees.views;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by Manikanta Tummalapenta on 14 Mar 2019
 */
class Node {
    Integer data;
    Integer hd;
    Node left, right;

    Node(Integer data) {
        this.data = data;
        this.hd = Integer.MAX_VALUE;
        this.left = this.right = null;
    }
}


class BinaryTree {

    private Node root;

    BinaryTree() {
    }

    BinaryTree(Node root) {
        this.root = root;
    }

    public void bottomView() {
        if (null == root) {
            return;
        }

        Integer hd = 0;

        Map<Integer, Integer> hdToDataMap = new TreeMap<>();
        Queue<Node> levelOrderQueue = new LinkedList<>();

        root.hd = hd;
        levelOrderQueue.add(root);

        while (!levelOrderQueue.isEmpty()) {

            Node temp = levelOrderQueue.remove();
            hd = temp.hd;

            hdToDataMap.put(hd, temp.data);

            if (null != temp.left) {
                temp.left.hd = hd-1;
                levelOrderQueue.add(temp.left);
            }

            if (null != temp.right) {
                temp.right.hd = hd+1;
                levelOrderQueue.add(temp.right);
            }
        }


        for (Map.Entry<Integer, Integer> entry : hdToDataMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
}


public class BottomView {

    public static void main(String[] args) {

        /* Tree 1 */
        Node root1 = new Node(20);
        root1.left = new Node(8);
        root1.right = new Node(22);
        root1.left.left = new Node(5);
        root1.left.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(25);
        root1.left.right.left = new Node(10);
        root1.left.right.right = new Node(14);

        BinaryTree binaryTree1 = new BinaryTree(root1);
        System.out.println("Bottom view of tree 1 is: ");
        binaryTree1.bottomView();


        /* Tree 2 */
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.left.right.right = new Node(5);
        root2.left.right.right.right = new Node(6);

        BinaryTree binaryTree2 = new BinaryTree(root2);
        System.out.println("Bottom view of tree 2 is: ");
        binaryTree2.bottomView();
    }
}
