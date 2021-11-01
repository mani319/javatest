package com.manikanta.dsa.monotonic;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Manikanta Tummalapenta on 25/09/21
 */
public class DecreasingMonotonicQueue {

    @Data
    public static class Item {
        int val, ind;

        public Item(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }

    Deque<DecreasingMonotonicQueue.Item> q;
    public int[] nearest;
    int defaultNearestValue;

    public DecreasingMonotonicQueue(int n, int defaultNearestValue) {
        this.q = new ArrayDeque<>();
        this.nearest = new int[n];
        this.defaultNearestValue = defaultNearestValue;
    }

    public void push(DecreasingMonotonicQueue.Item item) {
        // Pop while queue's last is lesser - kind of stack
        while (!q.isEmpty() && q.peekLast().val <= item.val) {
            q.removeLast();
        }

        q.addLast(item);
    }

    public void pushForNearest(DecreasingMonotonicQueue.Item item) {
        // Pop while queue's last is lesser
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

    public void pushForOverall(DecreasingMonotonicQueue.Item item) {
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

    public void popIfSame(int num) {
        if (!q.isEmpty() && num == q.peek().val) {
            q.pop();
        }
    }

    public Item getMax() {
        return q.peek();
    }
}
