package com.manikanta.dsa.linkedlist;

import com.manikanta.dsa.linkedlist.LinkedList.Node;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class Flatten {

    private Node flattenSingleLevel(Node head) {
        Merge merge = new Merge();

        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten all the next nodes
        head.next = flattenSingleLevel(head.next);

        // Merge current and next sorted lists using down
        head = merge.sortedMergeDown(head, head.next);

        return head;
    }


    private Node flattenMultiLevel(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (curr != tail) {

            if (curr.down != null) {
                tail.next = curr.down;

                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    // https://www.geeksforgeeks.org/flatten-a-multi-level-linked-list-set-2-depth-wise/
    static Node currTail = null;
    private static Node flattenMultiLevelDepthWise(Node head) {
        if (null == head) {
            return null;
        }

        currTail = head;
        Node next = head.next;

        head.next = flattenMultiLevelDepthWise(head.down);

        currTail.next = flattenMultiLevelDepthWise(next);

        return head;
    }


    public static void main(String[] args) {
        Flatten flatten = new Flatten();

        LinkedList sll = new LinkedList();
        sll.head = sll.push(sll.head, 30);
        sll.head = sll.push(sll.head, 8);
        sll.head = sll.push(sll.head, 7);
        sll.head = sll.push(sll.head, 5);

        sll.head.next = sll.push(sll.head.next, 20);
        sll.head.next = sll.push(sll.head.next, 10);

        sll.head.next.next = sll.push(sll.head.next.next, 50);
        sll.head.next.next = sll.push(sll.head.next.next, 22);
        sll.head.next.next = sll.push(sll.head.next.next, 19);

        sll.head.next.next.next = sll.push(sll.head.next.next.next, 45);
        sll.head.next.next.next = sll.push(sll.head.next.next.next, 40);
        sll.head.next.next.next = sll.push(sll.head.next.next.next, 35);
        sll.head.next.next.next = sll.push(sll.head.next.next.next, 28);

        sll.head = flatten.flattenSingleLevel(sll.head);
        sll.printListDown(sll.head);
        // Expected Output - 5 7 8 10 19 20 22 28 30 35 40 45 50


        LinkedList linkedList = new LinkedList();
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = linkedList.createList(arr1, arr1.length);
        Node head2 = linkedList.createList(arr2, arr2.length);
        Node head3 = linkedList.createList(arr3, arr3.length);
        Node head4 = linkedList.createList(arr4, arr4.length);
        Node head5 = linkedList.createList(arr5, arr5.length);
        Node head6 = linkedList.createList(arr6, arr6.length);
        Node head7 = linkedList.createList(arr7, arr7.length);
        Node head8 = linkedList.createList(arr8, arr8.length);

        /* modify child pointers to create the list shown above */
        head1.down = head2;
        head1.next.next.next.down = head3;
        head3.down = head4;
        head4.down = head5;
        head2.next.down = head6;
        head2.next.next.down = head7;
        head7.down = head8;

        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        linkedList.head = head1;

        linkedList.head = flatten.flattenMultiLevel(linkedList.head);
        linkedList.printList(linkedList.head);
        // Expected Output - 10 5 12 7 11 4 20 13 17 6 2 16 9 8 3 19 15

        Node head=new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.down = new Node(7);
        head.next.down.down = new Node(9);
        head.next.down.down.down = new Node(14);
        head.next.down.down.down.down= new Node(15);
        head.next.down.down.down.down.next= new Node(23);
        head.next.down.down.down.down.next.down = new Node(24);
        head.next.down.next = new Node(8);
        head.next.down.next.down = new Node(16);
        head.next.down.next.down.down= new Node(17);
        head.next.down.next.down.down.next= new Node(18);
        head.next.down.next.down.down.next.next= new Node(19);
        head.next.down.next.down.down.next.next.next
                = new Node(20);
        head.next.down.next.down.down.next.next.next.down
                = new Node(21);
        head.next.down.next.next = new Node(10);
        head.next.down.next.next.down = new Node(11);
        head.next.down.next.next.next = new Node(12);

        head = flattenMultiLevelDepthWise(head);
        linkedList.printList(head);
        // Expected Output - 1 2 7 9 14 15 23 24 8 16 17 18 19 20 21 10 11 12 3 4
    }
}
