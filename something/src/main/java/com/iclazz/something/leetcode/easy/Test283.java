package com.iclazz.something.leetcode.easy;

/**
 * move zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * Follow up: Could you minimize the total number of operations done?
 * Related Topics
 * 数组
 * 双指针
 * <p>
 * 👍 1725
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-09-02 17:46
 **/
public class Test283 {
    /**
     * 直接往前插，后面改0
     *
     * @param nums int[]
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int zeroIndex = 0;
        for (; i < nums.length; i++) {
            while (zeroIndex < nums.length && nums[zeroIndex] == 0) {
                zeroIndex++;
            }
            if (zeroIndex >= nums.length) {
                break;
            }
            nums[i] = nums[zeroIndex++];
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 直接往前插，后面改0
     *
     * @param nums int[]
     */
    public void moveZeroes2(int[] nums) {
        boolean existsZero = false;
        for (int i = 0, idx = 0; i < nums.length; i++) {
            if (!existsZero && nums[i] == 0) {
                existsZero = true;
            }
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
                if (existsZero) {
                    nums[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums2 = {0};
        int[] nums3 = {0, 1, 0};
        new Test283().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
