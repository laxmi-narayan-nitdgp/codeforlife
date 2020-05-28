package com.codeforlife.lax.array;

import java.util.PriorityQueue;

public class RunningStream {

    PriorityQueue<Integer> maxValues = new PriorityQueue<>();
    PriorityQueue<Integer> minValues = new PriorityQueue<>();

    public void add(int x) {

        minValues.add(x);
        balance();
    }

    private void balance() {

        PriorityQueue<Integer> small = minValues.size() < maxValues.size() ? minValues : maxValues;
        PriorityQueue<Integer> large = minValues.size() < maxValues.size() ? maxValues : minValues;

        int x = large.remove();
        small.add(x);
    }

    public double median() {
        PriorityQueue<Integer> small = minValues.size() < maxValues.size() ? minValues : maxValues;
        PriorityQueue<Integer> large = minValues.size() < maxValues.size() ? maxValues : minValues;
        if (small.size() == large.size()) {
            return (double) (small.peek() + large.peek()) / 2.0;
        }
        return large.peek();
    }
}
