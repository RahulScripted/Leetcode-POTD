// Title: Finding Pairs With a Certain Sum




from collections import Counter

class FindSumPairs:
    def __init__(self, nums1: list[int], nums2: list[int]):
        self.n1 = nums1
        self.n2 = nums2
        self.freq = Counter(nums2)

    def add(self, index: int, val: int) -> None:
        old_val = self.n2[index]
        self.freq[old_val] -= 1
        self.n2[index] += val
        self.freq[self.n2[index]] += 1

    def count(self, tot: int) -> int:
        return sum(self.freq[tot - x] for x in self.n1)