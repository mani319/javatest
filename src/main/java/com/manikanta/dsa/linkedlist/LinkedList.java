package com.manikanta.dsa.linkedlist;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        Node down;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

    /* Utility function to insert a node at beginning of the
       linked list */
    Node push(Node head_ref, int data) {

        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    // A utility function to create a linked list with n nodes. The data
    // of nodes is taken from arr[].  All child pointers are set as NULL
    Node createList(int arr[], int n) {
        Node node = null;
        Node p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.next = new Node(arr[i]);
                p = p.next;
            }
            p.next = p.down = null;
        }
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    void printListDown(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.down;
        }
        System.out.println();
    }
}
