package com.java.datastructure.CH07;

import java.util.*;

public class DigraphString {
    private final List<String> vertices;
    private int edges;
    private Map<String, LinkedList<String>> adj;

    public DigraphString(List<String> vertices) {
        if (vertices.size() < 0)
            throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.vertices = vertices;
        this.edges = 0;
        adj = new HashMap<String, LinkedList<String>>(vertices.size());
        for (String vertice : vertices) {
            adj.put(vertice, new LinkedList<String>());
        }
    }

    public void addEdge(String v, String w) {
        if (!vertices.contains(w)) {
            throw new IllegalArgumentException(w + " is not allowed to be added");
        }
        adj.get(v).add(w);
        edges++;
    }

    public LinkedList<String> adj(String v) {
        return adj.get(v);
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public Map<String, LinkedList<String>> getAdj() {
        return adj;
    }

    public void setAdj(Map<String, LinkedList<String>> adj) {
        this.adj = adj;
    }

    public List<String> getVertices() {
        return vertices;
    }

}
