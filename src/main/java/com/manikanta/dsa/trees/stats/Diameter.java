package com.manikanta.dsa.trees.stats;

import com.manikanta.dsa.trees.BinaryTree.Node;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by Manikanta Tummalapenta on 29 Nov 2019
 */
public class Diameter {

    private Integer naiveDiameter(Node root) {
        if (null == root) {
            return 0;
        }

        Integer lHei = Height.height(root.left);
        Integer rHei = Height.height(root.right);

        Integer lDia = naiveDiameter(root.left);
        Integer rDia = naiveDiameter(root.right);

        return Stream.of(lDia, rDia, lHei + rHei + 1).max(Integer::compareTo).get();
    }

    // Ref - https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
    private Integer optimisedDiameter(Node root) {
        AtomicInteger diameter = new AtomicInteger(0);

        heightCalc(root, diameter);

        return diameter.get();
    }

    private Integer heightCalc(Node root, AtomicInteger diameter) {
        if (null == root) {
            return 0;
        }

        Integer lHei = heightCalc(root.left, diameter);
        Integer rHei = heightCalc(root.right, diameter);

        diameter.set(Math.max(diameter.get(), lHei + rHei + 1));

        return Math.max(lHei, rHei) + 1;
    }


    public static void main(String[] args) {
        Diameter diameter = new Diameter();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Diameter is " + diameter.naiveDiameter(root));
        System.out.println("Diameter is " + diameter.optimisedDiameter(root));

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.left = new Node(5);
        root1.left.right.right = new Node(6);
        root1.right = new Node(7);
        root1.right.right = new Node(8);
        root1.right.right.right = new Node(9);
        root1.right.right.right.left = new Node(10);
        root1.right.right.right.left.left = new Node(11);
        root1.right.right.right.left.right = new Node(12);
        root1.right.right.right.right = new Node(13);

        System.out.println("Diameter1 is " + diameter.naiveDiameter(root1));
        System.out.println("Diameter1 is " + diameter.optimisedDiameter(root1));
    }
}
