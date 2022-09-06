package com.iclazz.something.leetcode.hard;

import java.util.Arrays;

/**
 * median of two sorted arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * Related Topics
 * 数组
 * 二分查找
 * 分治
 *
 * 👍 5799
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-09-06 16:33
 **/
public class Hard004 {
    /**
     * 粗暴排序取中间值法，时间复杂度较差。建议使用二分查找和分治法
     * @param nums1 int[]
     * @param nums2 int[]
     * @return double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            return l2 % 2 == 1 ? nums2[l2 / 2] : (nums2[l2 / 2 - 1] + nums2[l2 / 2] + 0.0) / 2;
        }
        if (l2 == 0) {
            return l1 % 2 == 1 ? nums1[l1 / 2] : (nums1[l1 / 2 - 1] + nums1[l1 / 2] + 0.0) / 2;
        }
        int l3 = l1 + l2;
        int[] num = new int[l3];
        System.arraycopy(nums1, 0, num, 0, l1);
        System.arraycopy(nums2, 0, num, l1, l2);
        Arrays.sort(num);
        return l3 % 2 == 1 ? num[l3 / 2] : (num[l3 / 2 - 1] + num[l3 / 2] + 0.0) / 2;
    }



    public static void main(String[] args) {
        System.out.println(new Hard004().findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(new Hard004().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(new Hard004().findMedianSortedArrays(new int[]{},new int[]{3,4}));
        System.out.println(new Hard004().findMedianSortedArrays(new int[]{0,0,0,0,0},new int[]{-1,0,0,0,0,0,1}));
    }
}
