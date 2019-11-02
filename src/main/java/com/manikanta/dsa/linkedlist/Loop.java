package com.manikanta.dsa.linkedlist;

import com.manikanta.dsa.linkedlist.LinkedList.Node;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class Loop {

    private void detectAndRemoveLoop(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                System.out.println("Loop detected... ");
                removeLoop(head, fast);
                return;
            }
        }

        System.out.println("There is no loop in the linked list...");
    }


    private void removeLoop(Node head, Node meetPoint) {
        Node first = head, second = meetPoint;

        while (first.next != second.next) {
            first = first.next;
            second = second.next;
        }
        second.next = null;

        System.out.println("Removed loop successfully...");
    }


    public static void main(String[] args) {
        Loop loop = new Loop();

        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        loop.detectAndRemoveLoop(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printList(list.head);
    }
}
