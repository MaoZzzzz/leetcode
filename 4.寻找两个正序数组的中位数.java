/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 复杂度为 O(log(m+n))，看到 log 那么大概率为二分查找
        // 二分查找的核心思想是二分，那么对于要查找的数字需要不停的折半
        // 板子中的二分查找是折半的排除需要查找的数组，排除一半不需要查找的数字，减少对比的次数
        // 这个题通过对比不用二分的情况会更好理解，在不用二分的情况，需要挨个对比两个数组的数字，要对比k次
        // 用了二分以后，就可以先对比两个 k / 2 - 1 的位置，这样可以直接排除掉 k / 2 的数字，正好对应了二分的思路

        // 本题中，要用到二分查找，首先需要确定要查找的元素，中位数也就是 (m + n) / 2(或 (m + n / 2 - 1))
        // 也就是说有 k 个元素比要查找的元素小，要查找的就是这个 k
        // 确定好要查找的元素，然后就是确定要使用二分的数组，这里二分的数组就是前面 k 个数
        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;
        if ((lengthNums1 + lengthNums2) % 2 == 1) {
            int mediaIndex = (lengthNums1 + lengthNums2) / 2;
            return getKth(nums1, nums2, mediaIndex);
        } else {
            int mediaIndex1 = (nums1.length + nums2.length) / 2;
            int mediaIndex2 = (nums1.length + nums2.length) / 2 - 1;
            return ((getKth(nums1, nums2, mediaIndex1) + getKth(nums1, nums2, mediaIndex2)) / 2);
        }
    }

    public int getKth(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 == length1) return nums2[index2 + (k / 2)];
            if (index2 == length1) return nums1[index1 + (k / 2)];
            if (k == 1) return Ma

            int newIndex1 = Math.min(index1 + (k / 2), length1);
            int newIndex2 = Math.min(index2 + (k / 2), length2);
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex1];
            if (pivot1 < pivot2) {
                index1 = newIndex1;
            } else {
                index2 = newIndex2;
            }
            k = k - (k / 2);
        }
    }
}
// @lc code=end
