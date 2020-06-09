package com.manikanta.interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Manikanta Tummalapenta on 28 May 2020
 */
public class Question1 {

    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {
        if (toys.size() == 0 || quotes.size() == 0
                || topToys == 0 || numToys == 0 || numQuotes == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Set<String> strs = new HashSet<>();
        for (int i = 0; i < numToys; i++) {
            strs.add(toys.get(i).toLowerCase());
        }
        Map<String, Integer> countMap = new HashMap<>();

        // Iterate each quote and split each word
        for (String quote : quotes) {
            String[] splitStrs = quote.split("\\W");
            Set<String> uniqueList = new HashSet<>();

            // Check for each word in quote with the given toys list
            for (String splitStr : splitStrs) {
                splitStr = splitStr.toLowerCase();

                // Add to count map if the string matches any of the toy and not seen in same quote.
                if (!uniqueList.contains(splitStr) && strs.contains(splitStr)) {
                    countMap.put(splitStr, countMap.getOrDefault(splitStr, 0) + 1);
                    uniqueList.add(splitStr);
                }
            }
        }

        // Create a priority Queue for sorting
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?
                        a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(countMap.entrySet());

        // While map is not empty insert into result list
        while (!maxHeap.isEmpty() && topToys-- > 0) {
            result.add(maxHeap.poll().getKey());
        }

        return new ArrayList<>(result);
    }


}
