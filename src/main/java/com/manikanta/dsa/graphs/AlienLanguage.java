package com.manikanta.dsa.graphs;

import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 16 May 2020
 *
 * Ref - https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */
public class AlienLanguage {

    static void printOrder(String[] words, int num) {
        Graph g = new Graph(num);

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    g.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> sortedList = TopologicalSort.topologicalSort(g);
        if (sortedList == null) {
            System.out.println("Incorrect order!!");
            return;
        }

        for (int alpha : sortedList) {
            System.out.print((char)('a' + alpha) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        printOrder(words, 3);

        String[] words2 = {"aba", "bba", "aaa"};
        printOrder(words2, 2);
    }
}
