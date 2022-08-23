package com.iclazz.something.leetcode.easy;

/**
 * merge sorted array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * Related Topics
 * 数组
 * 双指针
 * 排序
 * <p>
 * 👍 1538
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-23 10:34
 **/
public class Test088 {

    /**
     * 逆向思维从数组后方开始排
     * 时间复杂度O(m+n),但是内存空间40+M
     * @param nums1 int[]
     * @param m int
     * @param nums2 int[]
     * @param n int
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m -= 1;
        n -= 1;
        while (n >= 0) {
            if (m < 0) {
                nums1[n] = nums2[n];
                n--;
                continue;
            }
            nums1[m + n + 1] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    public static void main(String[] args) {
        new Test088().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        new Test088().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
