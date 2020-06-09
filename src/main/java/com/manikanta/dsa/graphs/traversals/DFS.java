package com.manikanta.dsa.graphs.traversals;

import com.manikanta.dsa.graphs.Graph;

/**
 * Created by Manikanta Tummalapenta on 04 Dec 2019
 */
public class DFS {

    private void traverseConnected(Graph g, Integer v) {
        boolean visited[] = new boolean[g.V];

        traverseUtil(g, v, visited);
    }

    private void traverseDisconnected(Graph g) {
        boolean visited[] = new boolean[g.V];

        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                traverseUtil(g, i, visited);
            }
        }
    }

    public static void traverseUtil(Graph g, Integer v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer n : g.adj[v]) {
            if (!visited[n]) {
                traverseUtil(g, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        dfs.traverseConnected(g, 2);

        System.out.println("\n*******************");

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");
        dfs.traverseConnected(g, 0);

        System.out.println("\n*******************");

        Graph g1 = new Graph(4);

        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal for disconnected graph");
        dfs.traverseDisconnected(g1);
    }
}
