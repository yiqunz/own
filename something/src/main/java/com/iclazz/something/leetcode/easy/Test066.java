package com.iclazz.something.leetcode.easy;

/**
 * plus one
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * Related Topics
 * 数组
 * 数学
 *
 * 👍 1060
 * 👎 0
 * @author yiqunz
 * @date 2022-08-22 10:11
 **/
public class Test066 {
    /**
     * 数组进位
     * @param digits int[]
     * @return int[]
     */
    public int[] plusOne(int[] digits) {
        //not carry
        if (digits[digits.length - 1] + 1 > 10) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                break;
            }
        }
        if (digits[0] != 0) {
            return digits;
        }
        //首位进一
        int[] newDigits = new int[digits.length + 1];
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        for (int i : new Test066().plusOne(new int[]{1, 2, 3})) {
            System.out.println(i);
        }
    }
}
