// Title: Maximum Number of Events That Can Be Attended




#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        sort(events.begin(), events.end());
        priority_queue<int, vector<int>, greater<int>> minHeap;
        int day = 0, idx = 0, n = events.size(), result = 0;

        while (!minHeap.empty() || idx < n) {
            if (minHeap.empty()) day = events[idx][0];

            while (idx < n && events[idx][0] <= day) {
                minHeap.push(events[idx][1]);
                idx++;
            }

            minHeap.pop();
            result++;
            day++;

            while (!minHeap.empty() && minHeap.top() < day) minHeap.pop();
        }

        return result;
    }
};