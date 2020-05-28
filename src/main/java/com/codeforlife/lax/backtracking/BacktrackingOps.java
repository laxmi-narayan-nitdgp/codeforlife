package com.codeforlife.lax.backtracking;

import com.codeforlife.util.PrintUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BacktrackingOps {

    public void ratInMazeWithMultipleJumps() {
        int[][] a = {{2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}};

        boolean[][] visited = new boolean[a.length][a[0].length];
        ratInMaze(a, visited, 0, 0);
    }

    public void ratInMaze(int[][] a, boolean[][] visit, int x, int y) {

        if (x == a.length - 1 && y == a[0].length - 1) {
            PrintUtil.print(visit);
            return;
        }

        visit[x][y] = true;

        for (int i = 0; i < a[x][y]; i++) {
            if (isSafeForJump(a, x + i, y)) {
                if (!visit[x][y]) {
                    ratInMaze(a, visit, x + i, y);
                }
            }

            if (isSafeForJump(a, x, y + i)) {
                if (!visit[x][y]) {
                    ratInMaze(a, visit, x, y + i);
                }
            }
        }
    }

    boolean isSafeForJump(int[][] a, int x, int y) {
        return (x >= 0 && y >= 0 && x < a.length && y < a[0].length);
    }


    public void printValidParenthesis() {

        String str = "(()()(())";
        removeInvalidParenthesis(str);
    }

    void removeInvalidParenthesis(String str) {
        if (str.isEmpty())
            return;

        HashSet<String> visit = new HashSet<String>();

        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;
        q.add(str);
        visit.add(str);

        while (!q.isEmpty()) {
            str = q.peek();
            System.out.println(" processing : " + q.remove());
            if (isValidString(str)) {
                System.out.println(str);
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++) {
                temp = str.substring(0, i) + str.substring(i + 1);
                System.out.println(" checking for " + temp);
                if (!visit.contains(temp)) {
                    q.add(temp);
                    visit.add(temp);
                }
            }
        }
    }

    // method returns true if string contains valid
// parenthesis
    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }


    public boolean isValidParenthesis(String str) {
        String output = new String();
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                c++;
            }
            if (str.charAt(i) == ')') {
                c--;
            }
            if (c < 0) {
                return false;
            }
        }
        System.out.println(output);
        return true;
    }

    public void graphColoring() {
        int[][] a = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}};
        int[][] color = new int[a.length][a[0].length];
    }


    public boolean color(int[][] a, int color[], int i, int j) {

        if (i > a.length || j >= a[0].length) {
            return false;
        }


        return false;
    }

    public void queenProblem() {
        int b[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        boolean[][] booleans = new boolean[b.length][b[0].length];

        queen(b, booleans, 0, booleans.length);

        PrintUtil.print(booleans);
    }


    boolean queen(int[][] a, boolean[][] board, int col, int max) {
        if (col >= max) {
            return true;
        }
        for (int i = 0; i < max; i++) {
            if (isBoardSafe(a, board, i, col)) {
                board[i][col] = true;
                if (queen(a, board, col + 1, max)) {
                    return true;
                }
                board[i][col] = false;

            }
        }
        return false;
    }

    private boolean isBoardSafe(int[][] a, boolean[][] board, int row, int col) {

        // check rows first
        for (int i = 0; i < board.length; i++) {
            if (board[row][i]) {
                return false;
            }
        }

        // check columns
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]) {
                return false;
            }
        }


        for (int i = 0; i < board.length; i++) {
            if ((row - i >= 0) && (col - i >= 0)) {
                if (board[row - i][col - i]) {
                    return false;
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            if ((row + i < board.length) && (col + i < board[0].length)) {
                if (board[row + i][col + i]) {
                    return false;
                }
            }
        }

        // upper diagonal
        for (int i = 0; i < a.length; i++) {
            if ((col + i < board.length)) {
                if (board[row][col + i]) {
                    return false;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (row + i < board.length) {
                if (board[row + i][col]) {
                    return false;
                }
            }
        }
        return true;
    }


    public void ratInMaze() {
        int a[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        boolean[][] path = new boolean[a.length][a[0].length];
        System.out.println(move(a, path, 0, 0));
        path[0][0] = true;
        PrintUtil.print(path);
    }

    boolean isSafe(int[][] a, int x, int y) {
        return (x >= 0 && y >= 0 && x < a.length && y < a[0].length && a[x][y] == 1);
    }

    boolean move(int[][] a, boolean[][] path, int x, int y) {

        if (x == a.length - 1 && y == a[0].length - 1) {
            return true;
        }

        int[] m_x = {0, 1};
        int[] m_y = {1, 0};

        for (int i = 0; i < m_x.length; i++) {
            path[x + m_x[i]][y + m_y[i]] = true;
            if (isSafe(a, x + m_x[i], y + m_y[i])) {
                if (move(a, path, x + m_x[i], y + m_y[i])) {
                    return true;
                }
            }
            path[x + m_x[i]][y + m_y[i]] = false;
        }
        return false;
    }

}
