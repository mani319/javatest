package com.manikanta.dsa.trees.check;

import com.manikanta.dsa.trees.BinaryTree.*;

/**
 * Created by Manikanta Tummalapenta on 29 Nov 2019
 */
public class CheckMirror {

    private boolean areMirror(Node t1, Node t2) {
        if (null == t1 && null == t2) {
            return true;
        }
        if (null == t1 || null == t2) {
            return false;
        }

        return (t1.data == t2.data &&
                areMirror(t1.left, t2.right) &&
                areMirror(t1.right, t2.left));
    }

    public static void main(String[] args) {
        CheckMirror checkMirror = new CheckMirror();

        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);

        System.out.println(checkMirror.areMirror(a, b));
    }
}
