package com.java.datastructure.CH07;

import java.util.*;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;

    public DepthFirstOrder(Digraph g) {
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        marked = new boolean[g.getVertices()];
        for (int v = 0; v < g.getVertices(); v++)
            if (!marked[v])
                dfs(g, v);
    }

    private void dfs(Digraph g, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w);
        }
        post.add(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }
}
