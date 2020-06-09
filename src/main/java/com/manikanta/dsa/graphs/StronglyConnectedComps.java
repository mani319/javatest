package com.manikanta.dsa.graphs;

import com.manikanta.dsa.graphs.traversals.DFS;
import org.junit.Assert;

import java.util.Stack;

/**
 * Created by Manikanta Tummalapenta on 16 May 2020
 *
 * Ref 1 - https://www.geeksforgeeks.org/strongly-connected-components/
 * Ref 2 - https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 */
public class StronglyConnectedComps {

    public static boolean isSingleStronglyConnected(Graph g) {
        boolean[] visited = new boolean[g.V];

        // Mark all vertices non visited
        for (int i = 0; i < g.V; i++) {
            visited[i] = false;
        }

        // Chose the vertex which have at least 1 outgoing edge
        // This step is not needed in case we have vertices which have at least 1 outgoing edge
        int v = 0;
        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() > 0) {
                v = i;
                break;
            }
        }

        // Do a DFS and checked whether all vertices are visited or not. If not visited, return false
        DFS.traverseUtil(g, v, visited);
        System.out.println();
        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        // Transpose the graph - Reverse the directions of edges
        Graph newG = transposeGraph(g);

        // Mark all vertices non visited
        for (int i = 0; i < g.V; i++) {
            visited[i] = false;
        }

        // Do a DFS and checked whether all vertices are visited or not. If not visited, return false
        DFS.traverseUtil(newG, v, visited);
        System.out.println();
        for (int i = 0; i < g.V; i++) {
            if (newG.adj[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void printStronglyConnectedComps(Graph g) {
        boolean[] visited = new boolean[g.V];

        // Mark all vertices non visited
        for (int i = 0; i < g.V; i++) {
            visited[i] = false;
        }

        Stack<Integer> st = new Stack<>();
        // DFS and add vertices to stack
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                fillStackDFS(g, i, visited, st);
            }
        }

        // Transpose the graph - Reverse the directions of edges
        Graph newG = transposeGraph(g);

        // Mark all vertices non visited
        for (int i = 0; i < g.V; i++) {
            visited[i] = false;
        }

        // While stack is empty, DFS the new graph and print
        while (!st.isEmpty()) {
            int elem = st.pop();

            if (!visited[elem]) {
                DFS.traverseUtil(newG, elem, visited);
                System.out.println();
            }
        }
    }

    private static void fillStackDFS(Graph g, int v, boolean[] visited, Stack<Integer> st) {
        visited[v] = true;

        for (Integer n : g.adj[v]) {
            if (!visited[n]) {
                fillStackDFS(g, n, visited, st);
            }
        }

        st.push(v);
    }

    private static Graph transposeGraph(Graph g) {
        Graph newGraph = new Graph(g.V);

        for (int i = 0; i < g.V; i++) {
            for (int node : g.adj[i]) {
                newGraph.addEdge(node, i);
            }
        }

        return newGraph;
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        printStronglyConnectedComps(g);

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        Assert.assertEquals(true, isSingleStronglyConnected(g1));

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        Assert.assertEquals(false, isSingleStronglyConnected(g2));
    }
}
