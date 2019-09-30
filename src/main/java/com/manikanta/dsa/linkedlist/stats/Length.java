package com.manikanta.dsa.linkedlist.stats;

/**
 * Created by Manikanta Tummalapenta on 16 Mar 2019
 */
public class Length {

    Node head;

    class Node {

        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
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


    public Integer getLengthRecursive() {
        return getLengthRecursiveUtil(this.head);
    }


    private Integer getLengthRecursiveUtil(Node node) {

        if (null == node) {
            return 0;
        }

        return 1 + getLengthRecursiveUtil(node.next);
    }


    public Integer getLengthIterative() {

        Node curr = head;

        if (null == curr) {
            return 0;
        }

        Integer len = 0;
        while (null != curr) {
            len += 1;
            curr = curr.next;
        }

        return len;
    }


    public static void main(String[] args) {
        Length llist = new Length();
        llist.insertAtEnd(1);
        llist.insertAtEnd(3);
        llist.insertAtEnd(1);
        llist.insertAtEnd(2);
        llist.insertAtEnd(1);

        System.out.println("Recursive count of nodes is " + llist.getLengthRecursive());
        System.out.println("Iterative count of nodes is " + llist.getLengthIterative());
    }
}
