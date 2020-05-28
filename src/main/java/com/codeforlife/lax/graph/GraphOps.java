package com.codeforlife.lax.graph;

import com.codeforlife.util.PrintUtil;

import java.util.*;

public class GraphOps {

    int pCount = 0;

    public void tsp() {

    }

    public void graphColoring() {
        constructGraph();
        PrintUtil.printGraph(graph);
        System.out.println();
        colorGraph();
    }

    private void colorGraph() {
        int vertex = 5;
        boolean[] avl = new boolean[vertex];
        int[] res = new int[vertex];

        Arrays.fill(res, -1);
        Arrays.fill(avl, true);
        res[0] = 1;
        for (int i = 1; i < vertex; i++) {

            Iterator<Integer> itr = graph.getOrDefault(i, new LinkedList<>()).iterator();

            while (itr.hasNext()) {
                int k = itr.next();
                if (res[k] != -1) {
                    avl[res[k]] = false;
                }
            }
            int color = 0;
            for (; color < vertex; color++) {
                if (avl[color]) {
                    break;
                }
            }
            res[i] = color;
//            PrintUtil.print(avl);
//            PrintUtil.print(res);
            Arrays.fill(avl, true);
        }

        PrintUtil.print(res);
    }

    private void constructGraph() {
        addEdgeUndirected(0, 1);
        addEdgeUndirected(0, 2);
        addEdgeUndirected(1, 2);
        addEdgeUndirected(1, 3);
        addEdgeUndirected(2, 3);
        addEdgeUndirected(3, 4);
    }

    private void constructGraph2() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 4);
        addEdge(2, 4);
        addEdge(4, 3);
    }

    public void printAllPathBetweenNodes() {
        int s = 1;
        int d = 4;
        bfs(s, d);
        System.out.println(pCount);
    }

    void bfs(int s, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int source = queue.remove();
            visited.add(source);
            List<Integer> dList = graph.getOrDefault(source, new LinkedList<>());
            for (Integer des : dList) {
                if (!visited.contains(des)) {
                    if (des == d) {
                        pCount++;
                    }
                    queue.add(des);
                }
            }
        }
    }


    public void printGraph(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " :  ");
            for (int x : entry.getValue()) {
                System.out.print(x + "->");
            }
            System.out.println();
        }
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private Stack<Integer> stack = new Stack<>();

    public void motherVertex() {
        int count = 6;
        visited.clear();
        getMotherGraph();
        System.out.println();
        for (int i = 1; i <= 6; i++) {
            dfs(i);
            if (visited.size() == count) {
                System.out.println(" mother vertex is " + i);
                break;
            } else {
                visited.clear();
            }
        }
    }

    public void transposeOfGraph() {
        getMotherGraph();
    }


    private void getMotherGraph() {
        graph.clear();

        addEdge(3, 2);
        addEdge(4, 1);
        addEdge(6, 5);
        addEdge(6, 3);
        addEdge(3, 4);
    }

    public void topologicalSortAlgo(int source) {
        topologicalSort(source);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }

    public void topologicalSort(int source) {
        visited.add(source);
        List<Integer> list = graph.getOrDefault(source, new LinkedList<>());
        for (int val : list) {
            if (!visited.contains(val)) {
                topologicalSort(val);
            }
        }
        stack.add(source);
    }

    public void bfs(int source) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {

            int node = queue.remove();
            System.out.print(node + " -> ");
            visited.add(node);

            List<Integer> destinations = graph.getOrDefault(node, new LinkedList<>());
            for (int val : destinations) {
                if (!visited.contains(val)) {
                    visited.add(val);
                    queue.add(val);
                }
            }
        }
    }

    public void dfs(int source) {
        visited.add(source);
        List<Integer> destination = graph.getOrDefault(source, new LinkedList<>());

        for (int d : destination) {
            if (!visited.contains(d)) {
                dfs(d);
            }
        }
        System.out.print(source + " -> ");
    }

    public GraphOps() {
        //setGraph2();
        //PrintUtil.printGraph(graph);
    }

    private void addEdgeUndirected(Integer source, Integer destination) {
        List<Integer> dest = graph.getOrDefault(source, new LinkedList<>());
        dest.add(destination);
        graph.put(source, dest);

        List<Integer> dest1 = graph.getOrDefault(destination, new LinkedList<>());
        dest1.add(source);
        graph.put(destination, dest1);
    }

    private void addEdge(Integer source, Integer destination) {
        List<Integer> dest = graph.getOrDefault(source, new LinkedList<>());
        dest.add(destination);
        graph.put(source, dest);
    }

    private void setGraph() {
        addEdge(1, 2);
        addEdge(1, 3);

        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(2, 6);

        addEdge(3, 1);
        addEdge(3, 2);
        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(5, 6);
    }

    private void setGraph2() {
        addEdge(1, 2);
        addEdge(1, 3);

        addEdge(2, 3);
        addEdge(2, 4);

        addEdge(3, 4);
        addEdge(4, 5);
        addEdge(5, 6);
    }
}
