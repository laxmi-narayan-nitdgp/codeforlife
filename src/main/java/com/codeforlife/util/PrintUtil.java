package com.codeforlife.util;

import java.util.List;
import java.util.Map;

public class PrintUtil {

    public static void print(boolean[] booleans) {
        for (boolean b : booleans) {
            System.out.print(b + " -> ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] a) {
        int len = a.length - 1;

        int i = 0;

        while (i < len) {
            int t = a[i];
            a[i] = a[len];
            a[len] = t;
            i++;
            len--;
        }
    }

    static public void print(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("+++++++++++++++++++++++++");
    }

    static public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
        System.out.println();
    }

    static public void print(boolean[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public void print(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }

    static public void printGraph(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer val : entry.getValue()) {
                System.out.print(val + ",");
            }
            System.out.println();
        }
    }
}
