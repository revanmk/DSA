class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums_res = nums1 + nums2
        n = len(nums_res)
        nums_res.sort()

        if n % 2 == 1:
            return float(nums_res[n // 2])
        else:
            mid1 = nums_res[n // 2 - 1]
            mid2 = nums_res[n // 2]
            return (float(mid1) + float(mid2)) / 2.0