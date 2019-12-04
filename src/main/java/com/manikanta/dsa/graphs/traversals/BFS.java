package com.manikanta.dsa.graphs.traversals;

import com.manikanta.dsa.graphs.Graph;
import java.util.LinkedList;

/**
 * Created by Manikanta Tummalapenta on 04 Dec 2019
 */
public class BFS {

    private void traverse(Graph g, Integer v) {
        boolean visited[] = new boolean[g.V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (Integer i : g.adj[v]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        bfs.traverse(g, 2);

        System.out.println("\n*******************");

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");
        bfs.traverse(g, 0);
    }
}
