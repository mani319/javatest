package com.manikanta.dsa.linkedlist;

/**
 * Created by Manikanta Tummalapenta on 16 Mar 2019
 */
public class Insertion {

    private Node head;

    class Node {

        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }


    public void insertAtBeginning(Integer value) {

        Node new_node = new Node(value);

        new_node.next = head;
        head = new_node;
    }


    public void insertAtEnd(Integer value) {

        if (null == head) {
            head = new Node(value);
            return;
        }

        Node new_node = new Node(value);

        Node last = head;
        while (null != last.next) {
            last = last.next;
        }

        last.next = new_node;
    }


    public void insertAfterNode(Node prevNode, Integer value) {

        if (null == prevNode) {
            System.out.println("previous node can't be null");
            return;
        }

        Node new_node = new Node(value);
        new_node.next = prevNode.next;
        prevNode.next = new_node;
    }


    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }


    public static void main(String[] args)
    {
        Insertion list = new Insertion();

        // Insert 6.  So linked list becomes 6->NUllist
        list.insertAtEnd(6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        list.insertAtBeginning(7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        list.insertAtBeginning(1);

        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        list.insertAtEnd(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        list.insertAfterNode(list.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        list.printList();
    }
}
