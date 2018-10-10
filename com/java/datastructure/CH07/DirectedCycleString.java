package com.java.datastructure.CH07;

import java.util.*;

public class DirectedCycleString {
    private Map<String, Boolean> marked;
    private Map<String, String> edgeTo;
    private Stack<String> cycle;
    private Map<String, Boolean> onStack;

    public DirectedCycleString(DigraphString g) {
        onStack = new HashMap<String, Boolean>(g.getVertices().size());
        edgeTo = new HashMap<String, String>();
        marked = new HashMap<String, Boolean>(g.getVertices().size());
        for (String v : g.getVertices()) {
            marked.put(v, Boolean.FALSE);
            onStack.put(v, Boolean.FALSE);
        }
        for (String vertice : g.getVertices()) {
            if (!marked.get(vertice)) {
                dfs(g, vertice);
            }
        }
    }

    private void dfs(DigraphString g, String vertice) {
        onStack.put(vertice, Boolean.TRUE);
        marked.put(vertice, Boolean.TRUE);
        for (String next : g.adj(vertice)) {
            System.out.println("dfs-1: start-" + vertice + ",next-" + next);
            if (hasCycle()) {
                System.out.println("Found cycle:");
                System.out.println(cycle());
                return;
            }
            if (!marked.get(next)) {
                System.out.println("dfs-2, put:" + next + "," + vertice);
                edgeTo.put(next, vertice);
                dfs(g, next);
            } else if (onStack.get(next)) {
                System.out.println("dfs-3");
                cycle = new Stack<String>();
                for (String x = vertice; !x.equals(next); x = edgeTo.get(x)) {
                    System.out.println("push:" + x);
                    cycle.push(x);
                }
                System.out.println("push next:" + next);
                cycle.push(next);
                System.out.println("push vertice:" + vertice);
                cycle.push(vertice);
            }
        }
        onStack.put(vertice, Boolean.FALSE);
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<String> cycle() {
        return cycle;
    }
}
