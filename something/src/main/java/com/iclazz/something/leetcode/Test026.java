package com.iclazz.something.leetcode;

/**
 * remove duplicates from sorted array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 * Related Topics
 * 数组
 * 双指针
 * <p>
 * 👍 2784
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-19 11:11
 **/
public class Test026 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length - count - 1; i++) {
            nums[i] = nums[i + count];
            while (length > i + count + 1 && nums[i + count] == nums[i + count + 1]) {
                count++;
            }
        }
        nums[length - count - 1] = nums[length - 1];
        return length - count;
    }

    /**
     * 双指针
     *
     * @param nums int[]
     * @return int
     */
    public int removeDuplicates2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        Test026 test026 = new Test026();
        int[] ints = {1, 1};
        System.out.println(test026.removeDuplicates2(ints));
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
