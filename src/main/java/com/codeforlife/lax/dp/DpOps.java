package com.codeforlife.lax.dp;

import com.codeforlife.util.PrintUtil;

import java.util.*;

public class DpOps {

    public void collectMaxCoins() {
        char a[][] = {{'E', 'C', 'C', 'C', 'C'},
                {'C', '#', 'C', '#', 'E'},
                {'#', 'C', 'C', '#', 'C'},
                {'C', 'E', 'E', 'C', 'E'},
                {'C', 'E', '#', 'C', 'E'}
        };
    }

    public int collect(char[][] a, int i, int j) {
        return -1;
    }


    public void findMinCoin() {
        int[] a = new int[]{15, 10, 5, 5, 5, 5};
        int v = 30;
        System.out.println(validate(a, a.length - 1, v));
        System.out.println(countIfPossible(a, a.length - 1, v, 0));
        //countMinCoins(a, v);
        countMinCoinsSingleDP(a, v);
    }

    public void countMinCoinsSingleDP(int[] a, int v) {
        int[] dp = new int[v + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= v; j++) {
                if (a[i - 1] <= j) {
                    System.out.print(" executing .. at " + j);
                    int sub_res = dp[j - a[i - 1]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
            System.out.println();
        }
        PrintUtil.print(dp);
    }

    // TODO: 11/06/20 fix this
    public void countMinCoins(int[] a, int v) {

        int[][] dp = new int[a.length + 1][v + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= v; j++) {
                if (a[i - 1] <= j) {
                    int p = 0;
                    if (dp[i - 1][j - a[i - 1]] != Integer.MAX_VALUE) {
                        p = dp[i - 1][j - a[i - 1]];
                    }
                    dp[i][j] = Math.min(dp[i - 1][j], p + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        PrintUtil.print(dp);
    }

    public boolean validate(int[] a, int i, int v) {
        if (v == 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        return validate(a, i - 1, v - a[i]) || validate(a, i - 1, v);
    }

    public int countIfPossible(int[] a, int i, int v, int c) {
        if (v == 0) {
            return c;
        }
        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(countIfPossible(a, i - 1, v - a[i], c + 1), countIfPossible(a, i - 1, v, c));
    }

    public void numberOfKPath() {

        int a[][] = {{1, 2, 3}, {4, 6, 5}, {3, 2, 1}};
        int k = 12;
        int count = numberOfPaths(a, a.length - 1, a[0].length - 1, k);
        System.out.print(count);
        findPathUsingDP(a, k);
    }

    boolean isSafe(int[][] a, int i, int j) {
        if (i >= 0 && j >= 0) {
            return true;
        }
        return false;
    }

    int numberOfPaths(int[][] a, int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) {
            return 0;
        }
        if (k == a[i][j] && i == 0 && j == 0) {
            return 1;
        }
        return numberOfPaths(a, i - 1, j, k - a[i][j])
                + numberOfPaths(a, i, j - 1, k - a[i][j]);
    }

    public void findPathUsingDP(int[][] a, int k) {

        int[][][] dp = new int[a.length + 1][a.length + 1][k + 1];

        System.out.println("\n " + findPathUsingDP(a, dp, a.length - 1, a[0].length - 1, k));
    }

    public int findPathUsingDP(int[][] a, int[][][] dp, int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) {
            return 0;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        if (k == a[i][j] && i == 0 && j == 0) {
            return 1;
        }
        dp[i][j][k] = findPathUsingDP(a, dp, i - 1, j, k - a[i][j]) + findPathUsingDP(a, dp, i, j - 1, k - a[i][j]);
        return dp[i][j][k];
    }

    static class Job {
        public int start;
        public int end;
        public int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static class SortJobs implements Comparator<Job> {

        @Override
        public int compare(Job job, Job job1) {
            if (job.end == job1.end) {
                return job.profit > job1.profit ? -1 : 1;
            }
            return job.end < job1.end ? -1 : 1;
        }
    }

    public void weightedJobsScheduling() {
        Job[] jobs = new Job[]{new Job(3, 10, 20),
                new Job(1, 2, 50),
                new Job(6, 19, 100),
                new Job(2, 100, 200)};

        List<Job> jobList = Arrays.asList(jobs);
        Collections.sort(jobList, new SortJobs());

        int[] dp = new int[jobList.size()];
        Map<Integer, List<Integer>> records = new HashMap<>();
        for (int i = 0; i < jobList.size(); i++) {
            dp[i] = jobList.get(i).profit;
            List<Integer> list = new LinkedList<>();
            list.add(i);
            records.put(i, list);
        }

        // TODO: 11/06/20 print the output.
        for (int i = 1; i < jobList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (jobList.get(i).start >= jobList.get(j).end) {
                    int pVal = dp[i];
                    int nVal = dp[j] + jobList.get(i).profit;
                    dp[i] = Math.max(pVal, nVal);
                    if (pVal != nVal) {
                        List<Integer> out = records.getOrDefault(j, new LinkedList<>());
                        out.add(i);
                        records.put(i, out);
                    }
                }
            }
        }
        PrintUtil.print(dp);
        for (Map.Entry<Integer, List<Integer>> entry : records.entrySet()) {
            System.out.print(entry.getKey() + " , ");
            for (Integer val : entry.getValue()) {
                System.out.print(val + " , ");
            }
            System.out.println();
        }
    }

    //todo
    public void lisAndPrintList() {
        int a[] = {10, 22, 9, 33, 1, 2, 3, 4, 5, 7, 9, 10, 11};
        //  int a[] = {10, 2, 9, 3, 5, 4, 6, 8};
        //int a[] = {10, 9, 8, 6, 5, 4};
        int lastElement = 0;
        int lastIndex = 0;
        int[] dp = new int[a.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    map.put(j, a[j]);
                    lastElement = a[i];
                    lastIndex = i;
                }
            }
        }
        System.out.println(" map size is : " + map.size());
        map.put(lastIndex, lastElement);
        PrintUtil.print(dp);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }

    public void printStringSeq() {
        String string = "ABCD";

        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < string.length(); j++) {
                for (int k = j; k <= j + i && k < string.length(); k++) {
                    System.out.print(string.charAt(k));
                }
            }
            System.out.println("---");
        }

    }

    public void lps() {
        String str = "AKXPOHPX";
        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 2)) {
                dp[i][i + 2] = 2;
            } else {
                dp[i][i + 2] = Math.max(dp[i][i + 1], dp[i + 1][i]);
            }
        }
        for (int k = 2; k < str.length(); k++) {
            for (int i = 0; i < str.length() - k; i++) {
                int j = i + k;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2 + Math.max(dp[i + 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        PrintUtil.print(dp);
        System.out.println(dp[0][str.length() - 1]);
    }

    public void task() {
        int[] h = new int[]{3, 6, 8, 7, 6};
        int[] l = new int[]{1, 5, 4, 5, 3};
        int[] dp = new int[h.length];
        System.out.println(task(h, l, h.length - 1));
        System.out.println(taskDP(h, l, h.length - 1, dp));
        taskDP(h, l);
        //PrintUtil.print(dp);
    }

    public int task(int[] h, int[] l, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(h[i] + task(h, l, i - 2), l[i] + task(h, l, i - 1));
    }

    public void taskDP(int[] h, int[] l) {
        int[] dp = new int[h.length + 1];
        dp[0] = 0;
        dp[1] = h[0];

        for (int i = 2; i <= h.length; i++) {
            dp[i] = Math.max(h[i - 1] + dp[i - 2], l[i - 1] + dp[i - 1]);
        }
        PrintUtil.print(dp);
        System.out.println(dp[h.length]);
    }

    public int taskDP(int[] h, int[] l, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        dp[i] = Math.max(dp[i], h[i] + task(h, l, i - 2));
        dp[i] = Math.max(dp[i], l[i] + task(h, l, i - 1));
        return dp[i];
    }

    public void highway() {
        int[] a = new int[]{6, 9, 12, 14};
        int[] r = new int[]{5, 6, 3, 7};

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], r[i]);
        }

        int t = 2;
        int m = 20;
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            if (map.containsKey(i)) {
                int prev = 0;
                if (i - t - 1 >= 0) {
                    prev = dp[i - t - 1];
                }
                dp[i] = Math.max(map.get(i) + prev, dp[i - 1]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        PrintUtil.print(dp);
        System.out.println(dp[m]);
    }

    public void vertex() {
    }

    public void wordBreak() {
        String wb = "AABC";
        Set<String> set = new HashSet<String>() {{
            add("A");
            add("AB");
            add("ABC");
        }};
        System.out.println(check(wb, set));
        System.out.println(wbDP(wb, set));
    }

    boolean check(String wb, Set<String> set) {
        if (wb.length() == 0) {
            return true;
        }
        for (int i = 1; i <= wb.length(); i++) {
            if (set.contains(wb.substring(0, i)) && check(wb.substring(i), set)) {
                return true;
            }
        }
        return false;
    }

    boolean wbDP(String wb, Set<String> set) {

        boolean[] dp = new boolean[wb.length() + 1];

        for (int i = 1; i <= wb.length(); i++) {

            if (dp[i] == false && set.contains(wb.substring(i))) {
                dp[i] = true;
            }
            if (dp[i]) {
                if (i == wb.length()) {
                    return true;
                }

                int j = i + 1;
                for (; j <= wb.length(); j++) {
                    if (dp[j] == false && set.contains(wb.substring(i, j))) {
                        dp[j] = true;
                    }
                }
                if (j == wb.length()) {
                    return true;
                }
            }
        }
        return false;
    }


    public void knapsack() {
        int[] val = new int[]{2, 3, 4, 10};
        int[] a = new int[]{2, 3, 4, 5};
        int n = 10;
        //System.out.println(knapsack(a, val, n));
        System.out.println(ks(a, val, n, a.length));
    }

    private int knapsack(int[] a, int[] val, int n) {

        int[][] dp = new int[a.length + 1][n + 1];

        for (int i = 1; i <= a.length; i++) {

            for (int j = 1; j <= n; j++) {

                if (a[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - a[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        PrintUtil.print(dp);
        return dp[a.length][n];
    }

    private int ks(int[] a, int[] v, int w, int i) {
        if (i < 1) {
            return 0;
        }

        if (w < 0) {
            return 0;
        }

        if (a[i - 1] > w) {
            return ks(a, v, w, i - 1);
        }

        return Math.max(ks(a, v, w, i - 1), v[i - 1] + ks(a, v, w - a[i - 1], i - 1));
    }
}