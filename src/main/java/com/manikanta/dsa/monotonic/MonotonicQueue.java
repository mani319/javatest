package com.manikanta.dsa.monotonic;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Manikanta Tummalapenta on 24/09/21
 */
@Data
public class MonotonicQueue {
    // Use this when we need smaller value on left/right side of current

    @Data
    public static class Item {
        int val, ind;

        public Item(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    Deque<Item> q;
    public int[] nearest;
    public int[] overall;
    int defaultNearestValue;

    public MonotonicQueue(int n, int defaultNearestValue) {
        this.q = new ArrayDeque<>();
        this.nearest = new int[n];
        this.defaultNearestValue = defaultNearestValue;
    }

    public void pushIncreasingForNearest(Item item) {
        // Pop while queue's top is greater
        while (!q.isEmpty() && q.peekLast().val >= item.val) {
            q.removeLast();
        }

        // If queue is empty, make nearest as default. Else which ever is on top.
        if (q.isEmpty()) {
            nearest[item.ind] = defaultNearestValue;
        } else {
            nearest[item.ind] = q.peekLast().ind;
        }

        q.addLast(item);
    }

    public void pushDecreasingForNearest(Item item) {
        // Pop while queue's top is lesser
        while (!q.isEmpty() && q.peekLast().val <= item.val) {
            q.removeLast();
        }

        // If queue is empty, make default as nearest. Else which ever is on top.
        if (q.isEmpty()) {
            nearest[item.ind] = defaultNearestValue;
        } else {
            nearest[item.ind] = q.peekLast().ind;
        }

        q.addLast(item);
    }

    public void pushDecreasingForOverall(Item item) {
        // Pop while queue's top is lesser
        while (!q.isEmpty() && q.peekLast().val <= item.val) {
            q.removeLast();
        }

        // If queue is empty, make default as nearest. Else which ever is on top.
        if (q.isEmpty()) {
            nearest[item.ind] = defaultNearestValue;
        } else {
            nearest[item.ind] = q.peekLast().ind;
        }

        if (q.isEmpty()) {
            q.addLast(item);
        }
    }
}
