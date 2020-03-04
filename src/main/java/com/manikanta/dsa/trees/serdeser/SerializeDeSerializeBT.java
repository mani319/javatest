package com.manikanta.dsa.trees.serdeser;

import com.manikanta.dsa.trees.BinaryTree;
import com.manikanta.dsa.trees.BinaryTree.Node;
import com.manikanta.dsa.trees.traversals.PreOrderTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 11 Feb 2020
 */
public class SerializeDeSerializeBT {

    private static String serializeBTUtil(Node root, String str) {

        if (null == root) {
            str += "null,";
        } else {

            str += root.data + ",";
            str = serializeBTUtil(root.left, str);
            str = serializeBTUtil(root.right, str);
        }

        return str;
    }

    private static Node deSerializeBTUtil(List<String> serTree) {

        if (serTree.get(0).equalsIgnoreCase("null")) {
            serTree.remove(0);
            return null;
        }

        Node node = new Node(Integer.valueOf(serTree.get(0)));
        serTree.remove(0);

        node.left = deSerializeBTUtil(serTree);
        node.right = deSerializeBTUtil(serTree);

        return node;
    }

    private static String serializeBT(Node root) {
        String str = "";
        return serializeBTUtil(root, str);
    }

    private static Node deSerializeBT(String str) {
        String[] data = str.split(",");
        List<String> serTree = new LinkedList<>(Arrays.asList(data));

        return deSerializeBTUtil(serTree);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        PreOrderTraversal.recursive(tree.root);
        System.out.println();

        String serializedBT = serializeBT(tree.root);
        System.out.println(serializedBT);

        Node root = deSerializeBT(serializedBT);
        PreOrderTraversal.recursive(root);
    }

}
