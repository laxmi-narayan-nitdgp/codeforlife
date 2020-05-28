package com.codeforlife.lax.linkedListPack;

public class LinkedListEx {
    public static void main(String[] args) {

        LinkedListOps linkedListOps = new LinkedListOps();
        ListNode listNode = linkedListOps.getListNode();
        linkedListOps.printList(listNode);
        listNode=linkedListOps.reverseList(listNode);
        linkedListOps.printList(listNode);
    }
}
