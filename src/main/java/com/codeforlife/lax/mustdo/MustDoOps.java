package com.codeforlife.lax.mustdo;

public class MustDoOps {

    public void countTriplet() {
        int[] a = {5, 32, 1, 7, 10, 50, 19, 21, 2};
    }

    public void subArrayWithSum() {
//        int[] a = {1, 4, 20, 3, 10, 5};
//        int k = 33;
        int[] a = {10, 2, -2, -20, 10};
        int k = -10;
        //subArraySum(a, k);
        subArraySumWithDoublePointer(a, k);
    }

    private void subArraySumWithDoublePointer(int[] a, int sum) {
        int l = 0;
        int r = l;
        int s = 0;
        while (r < a.length && l < r) {
            if (s == sum) {
                System.out.println(" sum found at : " + l + " , " + r);
                //return;
            }
            if (s < sum) {
                s += a[r];
                r++;
            } else {
                s -= a[l];
                l++;
            }
        }
    }

    private void subArraySum(int[] a, int s) {
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == s) {
                    System.out.println(" sum found between " + i + " , " + j);
                    return;
                }
            }
        }
    }

}
