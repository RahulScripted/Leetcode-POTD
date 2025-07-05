// Title: Find Lucky Integer in an Array


// Description: Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value. Return the largest lucky integer in the array. If there is no lucky integer return -1.




import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int lucky = -1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                lucky = Math.max(lucky, entry.getKey());
            }
        }

        return lucky;
    }
}