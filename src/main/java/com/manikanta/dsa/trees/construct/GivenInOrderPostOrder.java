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
public class GivenInOrderPostOrder {

    public BinaryTree.Node constructTree(int[] inorder, int[] postorder) {
        if (null == inorder || inorder.length == 0) {
            return null;
        }

        AtomicInteger postInd = new AtomicInteger(inorder.length - 1);
        int start = 0;
        int end = inorder.length - 1;
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return constructTree(start, end, postorder, postInd, inOrderMap);
    }

    private BinaryTree.Node constructTree(int start, int end,
                                          int[] preorder, AtomicInteger postInd,
                                          Map<Integer, Integer> inOrderMap) {
        if (start > end) {
            return null;
        }

        int nodeVal = preorder[postInd.getAndDecrement()];
        BinaryTree.Node root = new BinaryTree.Node(nodeVal);

        // Get this nodeVal's index in inOrder array
        int inOrderInd = inOrderMap.get(nodeVal);

        root.right = constructTree(inOrderInd + 1, end, preorder, postInd, inOrderMap);
        root.left = constructTree(start, inOrderInd - 1, preorder, postInd, inOrderMap);

        return root;
    }

    public static void main(String[] args) {
        GivenInOrderPostOrder givenInOrderPostOrder = new GivenInOrderPostOrder();
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};

        BinaryTree.Node node = givenInOrderPostOrder.constructTree(inorder, postorder);
        InOrderTraversal.recursive(node);
        System.out.println();
        PreOrderTraversal.recursive(node);
    }
}
