package com.manikanta.dsa.linkedlist;

/**
 * Created by Manikanta Tummalapenta on 16 Mar 2019
 */
public class Insertion {

    private ListNode head;

    class ListNode {

        Integer data;
        ListNode next;

        ListNode(Integer data) {
            this.data = data;
            this.next = null;
        }
    }


    public void insertAtBeginning(Integer value) {

        ListNode new_node = new ListNode(value);

        new_node.next = head;
        head = new_node;
    }


    public void insertAtEnd(Integer value) {

        if (null == head) {
            head = new ListNode(value);
            return;
        }

        ListNode new_node = new ListNode(value);

        ListNode last = head;
        while (null != last.next) {
            last = last.next;
        }

        last.next = new_node;
    }


    public void insertAfterNode(ListNode prevNode, Integer value) {

        if (null == prevNode) {
            System.out.println("previous node can't be null");
            return;
        }

        ListNode new_node = new ListNode(value);
        new_node.next = prevNode.next;
        prevNode.next = new_node;
    }


    public void printList()
    {
        ListNode tnode = head;
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
