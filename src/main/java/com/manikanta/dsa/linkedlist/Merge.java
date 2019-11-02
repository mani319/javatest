package com.manikanta.dsa.linkedlist;

import com.manikanta.dsa.linkedlist.LinkedList.Node;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class Merge {

    private Node sortedMergeRecursive(Node a, Node b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.data <= b.data) {
            a.next = sortedMergeRecursive(a.next, b);
            return a;
        } else {
            b.next = sortedMergeRecursive(a, b.next);
            return b;
        }
    }


    private Node sortedMergeIterative(Node a, Node b) {

        Node dummyNode = new Node(-1);
        Node result = dummyNode;

        while (a != null || b != null) {

            if (a == null) {
                result.next = b;
                break;
            }
            if (b == null) {
                result.next = a;
                break;
            }

            if (a.data <= b.data) {
                result.next = a;
                a = a.next;
            } else {
                result.next = b;
                b = b.next;
            }

            result = result.next;
        }

        return dummyNode.next;
    }


    Node sortedMergeDown(Node a, Node b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.data <= b.data) {
            a.down = sortedMergeDown(a.down, b);
            return a;
        } else {
            b.down = sortedMergeDown(a, b.down);
            return b;
        }
    }


    public static void main(String[] args) {
        Merge merge = new Merge();

        LinkedList list1 = new LinkedList();
        list1.head = new Node(1);
        list1.head.next = new Node(3);
        list1.head.next.next = new Node(5);
        list1.head.next.next.next = new Node(7);
        list1.head.next.next.next.next = new Node(9);

        LinkedList list2 = new LinkedList();
        list2.head = new Node(2);
        list2.head.next = new Node(4);
        list2.head.next.next = new Node(6);
        list2.head.next.next.next = new Node(8);
        list2.head.next.next.next.next = new Node(10);


        Node newListHead1 = merge.sortedMergeRecursive(list1.head, list2.head);
        LinkedList linkedList = new LinkedList();
        linkedList.printList(newListHead1);

        LinkedList list3 = new LinkedList();
        list3.head = new Node(1);
        list3.head.next = new Node(3);
        list3.head.next.next = new Node(5);
        list3.head.next.next.next = new Node(7);
        list3.head.next.next.next.next = new Node(9);

        LinkedList list4 = new LinkedList();
        list4.head = new Node(2);
        list4.head.next = new Node(4);
        list4.head.next.next = new Node(6);
        list4.head.next.next.next = new Node(8);
        list4.head.next.next.next.next = new Node(10);

        Node newListHead2 = merge.sortedMergeIterative(list3.head, list4.head);
        linkedList.printList(newListHead2);
    }
}
