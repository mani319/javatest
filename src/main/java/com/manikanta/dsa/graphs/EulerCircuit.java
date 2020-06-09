package com.manikanta.dsa.graphs;

import org.junit.Assert;

/**
 * Created by Manikanta Tummalapenta on 16 May 2020
 */
public class EulerCircuit {

    public static boolean isEulerCircuitPresent(Graph g) {

        if (!StronglyConnectedComps.isSingleStronglyConnected(g)) {
            return false;
        }

        // Find indegree for all vertices - This can be calculated during creation of graph to optimise
        int[] inDegree = new int[g.V];
        for (int i = 0; i < g.V; i++) {
            for (int node : g.adj[i]) {
                inDegree[node]++;
            }
        }

        // Compare indegree with outdegree. Both should be same
        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() != inDegree[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        Assert.assertEquals(true, isEulerCircuitPresent(g));
    }
}
