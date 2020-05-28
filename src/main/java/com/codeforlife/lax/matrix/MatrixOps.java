package com.codeforlife.lax.matrix;

import com.codeforlife.util.PrintUtil;

public class MatrixOps {

    public void rotate() {

        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int r = a.length;
        int c = a[0].length;

        rotate(a, r, c);
        PrintUtil.print(a);
    }

    public void rotate(int[][] a, int r, int c) {

        int i = 0;
        int j = 0;
        int prev = 0;

        while (i < r && j < c) {
            if (i + 1 == r || j + 1 == c) {
                break;
            }
            prev = a[i + 1][0];
            int tmp;
            // move first row
            for (int k = i; k < c; k++) {
                tmp = a[i][k];
                a[i][k] = prev;
                prev = tmp;
            }
            PrintUtil.print(a);
            i++;

            for (int k = i; k < r; k++) {
                tmp = a[k][c - 1];
                a[k][c - 1] = prev;
                prev = tmp;
            }
            c--;
            PrintUtil.print(a);

            if (i < r) {
                for (int k = c - 2; k >= j; k--) {
                    tmp = a[r - 1][k];
                    a[r - 1][k] = prev;
                    prev = tmp;
                }
                PrintUtil.print(a);
                r--;
            }
            if (j < c) {
                for (int k = r - 2; k >= i; k--) {
                    tmp = a[k][j];
                    a[k][j] = prev;
                    prev = tmp;
                }
                j++;
            }
            PrintUtil.print(a);
        }

    }
}
