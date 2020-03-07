package com.manikanta.dsa.trees.views;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.*;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by Manikanta Tummalapenta on 14 Mar 2019
 */
public class BottomView {

    public void bottomView(Node root) {
        if (null == root) {
            return;
        }

        Integer hd = 0;
        // This is a tree map - This stores in the natural ordering of keys
        Map<Integer, Integer> hdToDataMap = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();

        root.hd = hd;
        q.add(root);

        while (!q.isEmpty()) {

            Node temp = q.remove();
            hd = temp.hd;

            hdToDataMap.put(hd, temp.data);

            if (null != temp.left) {
                temp.left.hd = hd-1;
                q.add(temp.left);
            }

            if (null != temp.right) {
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hdToDataMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    class NewNode {
        Integer data;
        Integer level;

        NewNode(Integer data, Integer level) {
            this.data = data;
            this.level = level;
        }
    }

    public void bottomView2(Node root) {
        Map<Integer, NewNode> hdToDataMap = new TreeMap<>();
        bottomView2(root, 0, 0, hdToDataMap);

        for (Map.Entry<Integer, NewNode> entry : hdToDataMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    private void bottomView2(Node root, Integer hd, Integer currLevel, Map<Integer, NewNode> hdToDataMap) {

        if (null == root) {
            return;
        }

        if (!hdToDataMap.containsKey(hd) ||
                hdToDataMap.get(hd).level <= currLevel) {

            hdToDataMap.put(hd, new NewNode(root.data, currLevel));
        }

        bottomView2(root.left, hd - 1, currLevel + 1, hdToDataMap);
        bottomView2(root.right, hd + 1, currLevel + 1, hdToDataMap);
    }

    public static void main(String[] args) {
        BottomView bottomView = new BottomView();

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
        bottomView.bottomView(binaryTree1.getRoot());
        System.out.println();
        bottomView.bottomView2(binaryTree1.getRoot());
        System.out.println();

        /* Tree 2 */
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.left.right.right = new Node(5);
        root2.left.right.right.right = new Node(6);

        BinaryTree binaryTree2 = new BinaryTree(root2);
        System.out.println("Bottom view of tree 2 is: ");
        bottomView.bottomView(binaryTree2.getRoot());
        System.out.println();
        bottomView.bottomView2(binaryTree2.getRoot());
        System.out.println();

        /* Tree 3 */
        Node root3 = new Node(20);
        root3.left = new Node(8);
        root3.right = new Node(22);
        root3.left.left = new Node(5);
        root3.right.right = new Node(25);

        BinaryTree binaryTree3 = new BinaryTree(root3);
        System.out.println("Bottom view of tree 3 is: ");
        bottomView.bottomView(binaryTree3.getRoot());
        System.out.println();
        bottomView.bottomView2(binaryTree3.getRoot());
        System.out.println();
    }
}
