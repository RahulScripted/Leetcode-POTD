// Title: Maximum Number of Events That Can Be Attended




import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, idx = 0, n = events.length, result = 0;

        while (!minHeap.isEmpty() || idx < n) {
            if (minHeap.isEmpty()) day = events[idx][0];

            while (idx < n && events[idx][0] <= day) {
                minHeap.offer(events[idx][1]);
                idx++;
            }

            minHeap.poll();
            result++;
            day++;

            while (!minHeap.isEmpty() && minHeap.peek() < day) minHeap.poll();
        }

        return result;
    }
}