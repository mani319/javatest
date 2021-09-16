package com.manikanta.dsa.trees.traversals;

import com.manikanta.dsa.trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by Manikanta Tummalapenta on 15/09/21
 */
public class LevelOrderTraversal {

    List<List<Integer>> iterative(BinaryTree.Node root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                BinaryTree.Node curr = q.poll();
                currLevel.add(curr.data);

                if (Objects.nonNull(curr.left)) {
                    q.add(curr.left);
                }
                if (Objects.nonNull(curr.right)) {
                    q.add(curr.right);
                }
            }

            result.add(currLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(4);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(6);
        tree.root.left.left = new BinaryTree.Node(1);
        tree.root.left.right = new BinaryTree.Node(3);
        tree.root.right.left = new BinaryTree.Node(5);
        tree.root.right.right = new BinaryTree.Node(7);

        List<List<Integer>> iterative = levelOrderTraversal.iterative(tree.getRoot());
        System.out.print("Iterative: " + iterative);
        System.out.println();
    }
}
