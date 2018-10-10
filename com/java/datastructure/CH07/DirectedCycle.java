package com.java.datastructure.CH07;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g) {
        onStack = new boolean[g.getVertices()];
        edgeTo = new int[g.getVertices()];
        marked = new boolean[g.getVertices()];
        for (int v = 0; v < g.getVertices(); v++) {
            if (!marked[v])
                dfs(g, v);
        }
    }

    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            System.out.println("dfs-1: start-" + v + ",next-" + w);
            if (hasCycle()) {
                System.out.println("Found cycle:");
                System.out.println(cycle());
                return;
            }
            if (!marked[w]) {
                System.out.println("dfs-2");
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                System.out.println("dfs-3");
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
