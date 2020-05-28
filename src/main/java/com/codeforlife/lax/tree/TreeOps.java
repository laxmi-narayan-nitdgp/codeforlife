package com.codeforlife.lax.tree;

import com.codeforlife.util.Node;
import com.codeforlife.util.TreePrinter;

import java.util.*;

public class TreeOps {

    public void checkBST(Node node) {

        System.out.println(checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    boolean checkBST(Node node, int left, int right) {
        if (node == null) {
            return true;
        }
        if (node.data < left || node.data > right) {
            return false;
        }
        return checkBST(node.left, left, node.data - 1) && checkBST(node.right, node.data + 1, right);
    }

    public void diameter() {
    }

    public void findLCA(Node node, int x, int y) {
        Node out = lca(node, x, y);
        if (out == null) {
            System.out.println(" not LCA");
        } else {
            System.out.println(" lca found : " + out.data);
        }
    }

    public Node lca(Node node, int x, int y) {
        if (node == null) {
            return null;
        }

        if (node.data == x || node.data == y) {
            return node;
        }

        Node left = lca(node.left, x, y);
        Node right = lca(node.right, x, y);
        if (left != null && right != null) {
            return node;
        }
        if (left == null) {
            return right;
        }
        return left;
    }

    int c = -1;
    Node a = new Node(1);
    Node b = new Node(1);
    private int s = 0;

    public void checkMirror(Node a, Node b) {

        System.out.println("stat is : " + checkMirrorTree(a, b));
    }

    public boolean checkMirrorTree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return false;
        }
        if (a.data != b.data) {
            return false;
        }
        return checkMirrorTree(a.left, b.right) && checkMirrorTree(a.right, b.left);
    }

    public void checkIfSumTree(Node node) {
        System.out.println();
    }

    boolean checkForSumTree(Node node) {
        if (node == null) {
            return true;
        }
        return checkForSumTree(node.left) && checkForSumTree(node.right);//&& check(node);
    }

    public void checkChildSum(Node node) {

        System.out.println(checkChildSumm(node));
    }

    public boolean checkChildSumm(Node node) {
        if (node == null) {
            return true;
        }
        return sum(node) && checkChildSumm(node.left) && checkChildSumm(node.right);
    }

    boolean sum(Node node) {

        if (node.left == null && node.right == null) {
            return true;
        }

        int left = node.left != null ? node.left.data : 0;
        int right = node.right != null ? node.right.data : 0;
        return node.data == left + right;
    }

    public void printAllNodeAtKDistance(Node node, int k) {
        if (node == null) {
            return;
        }
        // find actual distance of node from root.
        // print all child nodes which are at k distance.
    }

    public void printLevel(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        int i = 0;
        while (!queue.isEmpty()) {

            while (!(queue.peek() == null)) {
                Node tmp = queue.remove();
                System.out.println(tmp.data + " is at " + i);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            queue.remove();
            if (!queue.isEmpty()) {
                queue.add(null);
            }
            i++;
        }
    }

    public void verticalOrder(Node node) {

        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(node);


        while (!queue.isEmpty()) {
            node = queue.remove();
            int d = node.distance;
            List<Integer> list = map.getOrDefault(d, new LinkedList<>());
            list.add(node.data);
            map.put(d, list);

            if (node.left != null) {
                Node tmp = node.left;
                tmp.setDistance(d - 1);
                queue.add(tmp);
            }

            if (node.right != null) {
                Node tmp = node.right;
                tmp.setDistance(d + 1);
                queue.add(tmp);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " = ");
            for (Integer val : entry.getValue()) {
                System.out.print(val + " -> ");
            }
            System.out.println();
        }

    }

    public void rightView(Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        node.setDistance(1);
        queue.add(node);

        while (!queue.isEmpty()) {

            node = queue.remove();

            if (node.right != null) {
                Node tmp = node.right;
                tmp.setDistance(node.distance + 1);
                queue.add(tmp);
            }

            if (node.left != null) {
                Node tmp = node.left;
                tmp.setDistance(node.distance + 1);
                queue.add(tmp);
            }

            if (!map.containsKey(node.distance)) {
                map.put(node.distance, node.data);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }

    public void leftView(Node node, int level) {

        if (node == null) {
            return;
        }

        if (c < level) {
            c++;
            System.out.print(node.data + " -> ");
        }
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);
    }

    public void topview(Node node) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.remove();

            int d = node.distance;

            if (node.left != null) {
                Node tmp = node.left;
                tmp.setDistance(d - 1);
                queue.add(tmp);
            }

            if (node.right != null) {
                Node tmp = node.right;
                tmp.setDistance(d + 1);
                queue.add(tmp);

            }
            if (!map.containsKey(d)) {
                map.put(d, node.data);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) + height(node.right) + 1;
    }

    public void levelOrder(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print(node.data + " -> ");
            return;
        } else {
            levelOrder(node.left, level - 1);
            levelOrder(node.right, level - 1);
        }
    }


    int currentLevel = -1;

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.data + " -> ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void findNthNode(Node node, int n) {
        if (node == null) {
            return;
        }
        findNthNode(node.left, n);
        s++;
        if (s == n) {
            System.out.println(node.data);
            return;
        }
        findNthNode(node.right, n);
    }

    //todo post order single traversal
    public void postOrder(Node node) {
        postOrderRec(node);
    }

    public void postOrderRec(Node node) {
        if (node == null) {
            return;
        }

        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " -> ");
    }

    public void postOrderStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {

            node = stack.pop();
            stack2.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " -> ");
        }

    }

    public void inorder(Node node) {

        inOrderRec(node);
        System.out.println();
        inOrderStack(node);
    }

    public void inOrderStack(Node node) {

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " -> ");
            node = node.right;
        }
    }

    public void inOrderRec(Node node) {
        if (node == null) {
            return;
        }
        inOrderRec(node.left);
        System.out.print(node.data + " -> ");
        inOrderRec(node.right);
    }

    public void preOrder(Node node) {
        TreePrinter.printNode(node);
        preOrderTraversal(node);
        System.out.println("");
        preOrderWithStack(node);
    }


    Node getSimpleTree() {
        Node node = new Node(10);
        node.setLeft(new Node(11));
        node.right = new Node(20);
        node.left.left = new Node(12);
        node.left.right = new Node(23);
        node.left.right.left = new Node(111);

        node.right.right = new Node(21);
        node.right.left = new Node(121);
        node.right.left.right = new Node(123);
        node.right.left.right.left = new Node(1110);

        return node;
    }
// greedy
    public Node getDiagonalTree() {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.left.right.right.right = new Node(9);
        root.left.right.right.right.right = new Node(911);
        return root;
    }

    public Node getBST() {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(19);
        return root;
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void preOrderWithStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {

            node = stack.pop();
            System.out.print(node.data + " -> ");
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    public Node getChildSum() {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(2);
        return root;
    }

    public Node getSumTree() {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        return root;
    }

    public void initMirrorTree() {
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
    }

    public Node getMirrorA() {
        initMirrorTree();
        return a;
    }

    public Node getMirrorB() {
        initMirrorTree();
        return b;
    }
}
