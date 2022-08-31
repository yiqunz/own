package com.iclazz.something.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * contains duplicate
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * Related Topics
 * 数组
 * 哈希表
 * 排序
 * <p>
 * 👍 803
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-31 10:42
 **/
public class Test217 {
    public boolean containsDuplicate(int[] nums) {
        //归并排序,某第一名大佬方法
        int length = nums.length;
        int temp;
        for (int i = 1; i < length; i++) {
            temp = nums[i];
            int j = i;
            //这里判断的是小于，那么后面的都比他小或者相等
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            //此方法必须是j>0
            if (j > 0 && nums[j - 1] == temp) {
                return true;
            }
            nums[j] = temp;
        }
        return false;
    }

    /**
     * API排序循环
     *
     * @param nums int[]
     * @return boolean
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希判重
     *
     * @param nums int[]
     * @return boolean
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test217().containsDuplicate3(new int[]{1, 2, 3, 4}));
        System.out.println(new Test217().containsDuplicate3(new int[]{1, 2, 3, 4, 1}));
    }

}
