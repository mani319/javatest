package com.manikanta.dsa.arrays.intervals;

import com.manikanta.dsa.disjointset.DisjointSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Manikanta Tummalapenta on 23/09/21
 * <p>
 * Ref - https://www.geeksforgeeks.org/job-sequencing-problem/
 * https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/
 */
public class JobSequence {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Job implements Comparator<Job> {
        char id;
        int deadline, profit;

        public int compare(Job j1, Job j2) {
            return Integer.compare(j2.profit, j1.profit);
        }
    }

    private int getMaxDeadLine(List<Job> jobs) {
        int maxDeadLine = 0;
        for (Job job : jobs) {
            maxDeadLine = Math.max(job.deadline, maxDeadLine);
        }
        return maxDeadLine;
    }

    public void printSequence(List<Job> jobs) {
        // Sort based on profit
        jobs.sort(new Job());

        // Get max deadline
        int maxDeadLine = getMaxDeadLine(jobs);
        // Create disjoint set of size maxDeadLine+1
        DisjointSet ds = new DisjointSet(maxDeadLine + 1);

        // Iterate and find the latest slot and assign it
        for (Job job : jobs) {
            // Find the latest slot for current job
            Integer slot = ds.find(job.deadline);

            // If at least 1 slot available
            if (slot > 0) {
                // Update slot to make previous slot's root as it's parent. Nothing but merge.
                ds.union(slot, ds.find(slot - 1));

                // print the current job id
                System.out.print(job.id + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        JobSequence jobSequence = new JobSequence();
        List<Job> arr = new ArrayList<>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        System.out.println("Following jobs need to be " +
                "executed for maximum profit");

        jobSequence.printSequence(arr);
    }
}
