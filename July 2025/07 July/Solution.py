// Title: Maximum Number of Events That Can Be Attended




import heapq

class Solution:
    def maxEvents(self, events: list[list[int]]) -> int:
        events.sort()
        min_heap = []
        day = 0
        idx = 0
        result = 0
        n = len(events)

        while idx < n or min_heap:
            if not min_heap:
                day = events[idx][0]

            while idx < n and events[idx][0] <= day:
                heapq.heappush(min_heap, events[idx][1])
                idx += 1

            heapq.heappop(min_heap)
            result += 1
            day += 1

            while min_heap and min_heap[0] < day:
                heapq.heappop(min_heap)

        return result