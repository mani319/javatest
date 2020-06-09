package com.manikanta.dsa.graphs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Manikanta Tummalapenta on 01 Mar 2020
 *
 * Ref - https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 */
public class TopologicalSort {

    public static List<Integer> topologicalSort(Graph g) {
        List<Integer> topologicalSort = new ArrayList<>();

        // Find inDegree of each Vertex
        int[] inDegree = new int[g.V];
        for (int i = 0; i < g.V; i++) {
            for (int adjNode : g.adj[i]) {
                inDegree[adjNode]++;
            }
        }

        // Add all nodes with inDegree as 0 into Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < g.V; i++) {
            if (0 == inDegree[i]) {
                queue.add(i);
            }
        }

        // Initiate a count variable to check how many nodes are visited
        int count = 0;
        while (!queue.isEmpty()) {
            // Pop from Queue and add to result list
            Integer node = queue.poll();
            topologicalSort.add(node);

            // For all adjacent nodes of removed node
            for (int adjNode : g.adj[node]) {
                // reduce inDegree
                inDegree[adjNode]--;

                // If inDegree becomes 0, add it to Queue
                if (0 == inDegree[adjNode]) {
                    queue.add(adjNode);
                }
            }

            count++;
        }

        // If count of visited is not same as number of nodes, there is a cycle
        if (count != g.V) {
            System.out.println("There exists a cycle in the graph");
            return null;
        }

        return topologicalSort;
    }

    public static void main(String args[]) {

        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        List<Integer> topologicalSort = new ArrayList<>(Arrays.asList(4, 5, 2, 0, 3, 1));
        Assert.assertEquals(topologicalSort, topologicalSort(g));
    }
}
