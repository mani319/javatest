package com.manikanta.dsa.trees.construct;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.traversals.InOrderTraversal;
import com.manikanta.dsa.trees.traversals.PreOrderTraversal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Manikanta Tummalapenta on 16/09/21
 */
public class GivenInOrderPreOrder {

    // preInd = 0
    public BinaryTree.Node constructTree(int[] inorder, int[] preorder) {
        if (null == inorder || inorder.length == 0) {
            return null;
        }

        AtomicInteger preInd = new AtomicInteger(0);
        int start = 0;
        int end = inorder.length - 1;
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return constructTree(start, end, preorder, preInd, inOrderMap);
    }

    private BinaryTree.Node constructTree(int start, int end,
                                          int[] preorder, AtomicInteger preInd,
                                          Map<Integer, Integer> inOrderMap) {
        if (start > end) {
            return null;
        }

        int nodeVal = preorder[preInd.getAndIncrement()];
        BinaryTree.Node root = new BinaryTree.Node(nodeVal);

        // Get this nodeVal's index in inOrder array
        int inOrderInd = inOrderMap.get(nodeVal);

        root.left = constructTree(start, inOrderInd - 1, preorder, preInd, inOrderMap);
        root.right = constructTree(inOrderInd + 1, end, preorder, preInd, inOrderMap);

        return root;
    }

    public static void main(String[] args) {
        GivenInOrderPreOrder givenInOrderPreOrder = new GivenInOrderPreOrder();
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};

        BinaryTree.Node node = givenInOrderPreOrder.constructTree(inorder, preorder);
        InOrderTraversal.recursive(node);
        System.out.println();
        PreOrderTraversal.recursive(node);
    }
}
