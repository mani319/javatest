package com.manikanta.dsa.linkedlist;

import com.manikanta.dsa.linkedlist.LinkedList.Node;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class Reverse {

    private static Node reverseWhole(Node head) {

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }


    private static Node reverseInBatches(Node head, int batchSize) {

        Node prev = null;
        Node curr = head;
        Node next = null;

        int iterator = 0;
        while (curr != null && iterator < batchSize) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            iterator += 1;
        }

        if (next != null) {
            head.next = reverseInBatches(next, batchSize);
        }
        head = prev;

        return head;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next.next = new Node(50);

        System.out.println("Given Linked list");
        list.printList(list.head);

        list.head = reverseWhole(list.head);

        System.out.println("Reversed linked list ");
        list.printList(list.head);
        list.head = reverseWhole(list.head);

        list.head = reverseInBatches(list.head, 3);
        System.out.println("Reversed linked list in batches ");
        list.printList(list.head);
    }
}
