package com.codeforlife.lax.linkedListPack;

public class LinkedListOps {

    public void blockReverse(ListNode listNode, int blockSize) {

    }

    ListNode getListNode() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        return listNode;
    }

    public ListNode reverseList(ListNode listNode) {
        ListNode prev = null;
        ListNode next = null;

        while (listNode != null) {
            next = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = next;
        }
        return prev;
    }

    public void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.data + " -> ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
