package com.codeforlife.lax.hds;

import java.util.PriorityQueue;

public class HeapOps {

    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public void sortNearlySortedArray() {
        int a[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        for (int i = 0; i < a.length; i++) {
            if (i >= k) {
                System.out.print(heap.remove() + " , ");
            }
            heap.add(a[i]);
        }

        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " -> ");
        }
    }
}
