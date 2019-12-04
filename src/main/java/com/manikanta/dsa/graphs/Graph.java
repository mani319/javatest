package com.manikanta.dsa.graphs;

import java.util.LinkedList;

/**
 * Created by Manikanta Tummalapenta on 04 Dec 2019
 */
public class Graph {

    // Number of vertices
    public Integer V;
    public LinkedList<Integer>[] adj;

    public Graph(Integer v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (Integer i=0; i<v; ++i)
            this.adj[i] = new LinkedList<>();
    }

    public void addEdge(Integer v, Integer w) {
        this.adj[v].add(w);
    }
}
