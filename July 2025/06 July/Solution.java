// Title: Finding Pairs With a Certain Sum




import java.util.*;

class FindSumPairs {
    private int[] n1, n2;
    private Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.n1 = nums1;
        this.n2 = nums2;
        freq = new HashMap<>();
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = n2[index];
        freq.put(oldVal, freq.get(oldVal) - 1);
        n2[index] += val;
        freq.put(n2[index], freq.getOrDefault(n2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int x : n1) {
            count += freq.getOrDefault(tot - x, 0);
        }
        return count;
    }
}