package com.iclazz.something.leetcode.easy;

/**
 * maximum subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Related Topics
 * 数组
 * 分治
 * 动态规划
 *
 * 👍 5275
 * 👎 0
 * @author yiqunz
 * @date 2022-09-05 11:02
 **/
public class Test053 {
    /**
     * 不打草稿版本
     * @param nums int[]
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int maximumNum = nums[0];
        if (nums.length == 1) {
            return maximumNum;
        }
        int positiveSum = maximumNum;
        int allSum = maximumNum;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (positiveSum < allSum) {
                positiveSum = allSum;
            }
            if (num >= 0) {
                if (allSum < 0) {
                    allSum = 0;
                }
                allSum += num;
            } else {
                if (allSum + num > 0) {
                    allSum += num;
                } else {
                    allSum = num;
                }
            }
        }
        return Math.max(allSum, positiveSum);
    }

    /**
     * 动态规划
     * @param nums int[]
     * @return int
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Test053().maxSubArray2(nums));
        System.out.println(new Test053().maxSubArray2(new int[]{5,4,-1,7,8}));
        System.out.println(new Test053().maxSubArray2(new int[]{-1}));
        System.out.println(new Test053().maxSubArray2(new int[]{-2,-1}));
    }
}
