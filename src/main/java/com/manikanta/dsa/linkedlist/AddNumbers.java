package com.manikanta.dsa.linkedlist;

import com.manikanta.dsa.linkedlist.LinkedList.Node;

/**
 * Created by Manikanta Tummalapenta on 02 Nov 2019
 */
public class AddNumbers {

    /**
     * Input: List1: 7->5->9->4->6  // represents number 64957
              List2: 8->4 //  represents number 48
       Output: Resultant list: 5->0->0->5->6  // represents number 65005
     */
    private Node addTwoListsLSD(Node head1, Node head2) {
        int carry = 0, sum = 0;
        Node dummy = new Node(-1), result = dummy;

        while (head1 != null || head2 != null) {
            sum = ((head1 != null) ? head1.data : 0) +
                    ((head2 != null) ? head2.data : 0) + carry;
            carry = sum >= 10 ? 1 : 0;

            result.next = new Node(sum % 10);
            result = result.next;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry == 1) {
            result.next = new Node(1);
        }

        return dummy.next;
    }

    /**
     * Input:
         First List: 5->6->3  // represents number 563
         Second List: 8->4->2 //  represents number 842
       Output
         Resultant list: 1->4->0->5  // represents number 1405
     */
    private Node addTwoListsMSDWithoutExtraMemory(Node head1, Node head2) {
        Reverse reverse = new Reverse();

        head1 = reverse.reverseWhole(head1); // O(m)
        head2 = reverse.reverseWhole(head2); // O(n)

        Node result = addTwoListsLSD(head1, head2); // O(m+n)
        result = reverse.reverseWhole(result); // O(m+n)

        reverse.reverseWhole(head1); // O(m)
        reverse.reverseWhole(head2); // O(n)

        return result;
    }


    Node result, curr;
    int carry = 0;
    private void addTwoListsMSD(Node head1, Node head2) {
        LinkedList linkedList = new LinkedList();

        if (head1 == null) {
            result = head2;
            return;
        }
        if (head2 == null) {
            result = head1;
            return;
        }

        int len1 = linkedList.getsize(head1);
        int len2 = linkedList.getsize(head2);

        if (len1 == len2) {

            addSameSize(head1, head2);
        } else {
            // Swap head1 and head2 if list2 is bigger
            if (len1 < len2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }

            // Traverse diff len in head1
            int diff = Math.abs(len1 - len2);
            Node temp = head1;
            while (diff-- >= 0) {
                curr = temp;
                temp = temp.next;
            }

            // Now temp and head2 lists are of same size
            addSameSize(curr, head2);

            propagateCarry(head1);
        }

        if (carry == 1) {
            addNodeAtHeadOfResult(1);
        }
    }

    private void addSameSize(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return;
        }

        addSameSize(head1.next, head2.next);

        int sum = head1.data + head2.data + carry;
        carry = sum / 10;
        sum %= 10;

        addNodeAtHeadOfResult(sum);
    }

    private void propagateCarry(Node head1) {
        if (head1 != curr) {
            propagateCarry(head1.next);

            int sum = carry + head1.data;
            carry = sum / 10;
            sum %= 10;

            addNodeAtHeadOfResult(sum);
        }
    }

    private void addNodeAtHeadOfResult(int data) {
        Node newNode = new Node(data);
        newNode.next = result;
        result = newNode;
    }


    public static void main(String[] args) {
        AddNumbers addNumbers = new AddNumbers();

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        // creating first list
        list1.head = new Node(7);
        list1.head.next = new Node(5);
        list1.head.next.next = new Node(9);
        list1.head.next.next.next = new Node(4);
        list1.head.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list1.printList(list1.head);

        // creating second list
        list2.head = new Node(8);
        list2.head.next = new Node(4);
        System.out.print("Second List is ");
        list2.printList(list2.head);

        // add the two lists and see the result
        Node rs = addNumbers.addTwoListsLSD(list1.head, list2.head);
        System.out.print("Resultant List is ");
        list1.printList(rs);

        Node rs2 = addNumbers.addTwoListsMSDWithoutExtraMemory(list1.head, list2.head);
        System.out.print("Resultant List adding MSD without extra memory is ");
        list1.printList(rs2);

        addNumbers.addTwoListsMSD(list1.head, list2.head);
        System.out.print("Resultant List adding MSD is ");
        list1.printList(addNumbers.result);
    }
}
