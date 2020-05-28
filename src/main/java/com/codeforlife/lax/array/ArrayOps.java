package com.codeforlife.lax.array;

import com.codeforlife.util.PrintUtil;

import java.util.PriorityQueue;

public class ArrayOps {




    public void moveAllZeros() {

        int[] a = new int[]{1, 2, 0, 4, 3, 0, 5, 0};

        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[k++] = a[i];
            }
        }
        for (; k < a.length; k++) {
            a[k] = 0;
        }
        PrintUtil.print(a);
    }

    public void arrangePositiveNegative() {

        int[] a = {-10, -1, 2, -3, 4, 5, 6, -7, 8, 9, 11, -1, 2, 2, 1, 1, 1, 1};

        int i = 0, k = a.length - 1;
// o(n)
        while (i < k) {
            while (a[i] <= 0) {
                i++;
            }
            while (a[k] > 0) {
                k--;
            }
            if (i < k) {
                int x = a[i];
                a[i] = a[k];
                a[k] = x;
            }
        }
        PrintUtil.print(a);
        k++;
        // o(n)
        i = 0;
        while (i < k && k < a.length) {
            int x = a[i];
            a[i] = a[k];
            a[k] = x;
            i += 2;
            k++;
        }

        PrintUtil.print(a);
    }

    public void rearrange() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int[] tmp = new int[arr.length];

        int lastEvenIndex = arr.length % 2 == 0 ? arr.length : arr.length - 1;
        int len = arr.length;

        while (lastEvenIndex >= 1) {
            tmp[lastEvenIndex - 1] = arr[len - 1];
            lastEvenIndex -= 2;
            len--;
        }
        int k = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 0) {
                tmp[i] = arr[k];
                k++;
            }
        }
        PrintUtil.print(tmp);
    }

    public void reverse() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        reverse(a, a.length - 1);
        PrintUtil.print(a);
    }

    public void reverse(int[] a, int i) {
        if (i >= 0) {
            int k = a[i];
            reverse(a, i - 1);
            a[a.length - 1 - i] = k;
        }
    }

    public void arrange() {
        int[] a = new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        for (int i = 0; i < a.length; ) {
            if (a[i] != -1 && a[i] != i) {
                int x = a[a[i]];
                a[a[i]] = a[i];
                a[i] = x;
            } else {
                i++;
            }
        }
        PrintUtil.print(a);
    }


    public void runningStream() {
        int[] a = new int[]{5, 5, 10, 15, 20};
        RunningStream runningStream = new RunningStream();
        for (int i = 0; i < a.length; i++) {
            runningStream.add(a[i]);
            System.out.println(runningStream.median());
        }
    }

    public void shuffle() {
        int a[] = {1, 3, 5, 7, 2, 4, 6, 8};

    }

    public void shuffle(int[] a, int l, int h) {

    }

    public void mergeKSortedArrays() {
        int[][] arr = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        Holder[] holders = new Holder[arr.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            holders[i] = new Holder(arr[i], 0);
            queue.add(arr[i][0]);
        }

        //int k = arr.length * arr[0].length;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(" -> " + x);
            for (int i = 0; i < arr.length; i++) {
                if (holders[i].peek() == x) {
                    if (holders[i].hasNext()) {
                        int k = holders[i].remove();
                        queue.add(k);
                    }
                }
            }
        }
        System.out.println();
    }


    private static class Holder {
        private int[] a;
        private int i;

        public Holder(int[] a, int i) {
            this.a = a;
            this.i = i;
        }

        public boolean hasNext() {
            return (i < a.length - 1);
        }

        public int peek() {
            return a[i];
        }

        public int remove() {
            if (hasNext()) {
                int k = a[++i];
                return k;
            }
            return -1;
        }
    }

}
