package com.iclazz.something.leetcode.easy;

/**
 * add digits
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 * Constraints:
 *
 * 0 <= num <= 231 - 1
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 *
 * Related Topics
 * 数学
 * 数论
 * 模拟
 *
 * 👍 539
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-09-01 09:39
 **/
public class Test258 {
    /**
     * 递归法
     * @param num int
     * @return int
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return addDigits(temp);
    }

    /**
     * 数论,对9取余
     * 相似的判断一个数能不能被3整除的思路
     * @param num int
     * @return int
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Test258().addDigits2(38));
        System.out.println(new Test258().addDigits2(11));
        System.out.println(new Test258().addDigits2(0));
        System.out.println(new Test258().addDigits2(9));
        System.out.println(new Test258().addDigits2(11111));
    }

}
