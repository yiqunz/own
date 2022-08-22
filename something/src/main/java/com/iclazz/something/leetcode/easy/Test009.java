package com.iclazz.something.leetcode.easy;

/**
 * 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 *
 * @author yiqunz
 * @date 2022-08-18 10:44
 **/
public class Test009 {
    /**
     * 字符串解法，不推荐
     *
     * @param x int
     * @return boolean
     */
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        if (x < 0) {
            return false;
        }
        int length = xStr.length();
        if (length == 1) {
            return true;
        }
        char[] charArray = xStr.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (charArray[i] != charArray[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 前后位数数值比较法，不推荐
     *
     * @param x int
     * @return boolean
     */
    public boolean isPalindrome2(int x) {
        int ten = 10;
        if (x < 0) {
            return false;
        }
        if (x < ten) {
            return true;
        }
        int digits = 1;
        int num = x;
        while (num >= ten) {
            digits *= ten;
            num /= ten;
        }
        while (digits >= ten) {
            if (x / digits != x % ten) {
                return false;
            }
            x = x % digits / ten;
            digits /= 100;
        }
        return true;
    }

    /**
     * 构建倒叙数字比较
     *
     * @param x int
     * @return boolean
     */
    public boolean isPalindrome3(int x) {
        int ten = 10;
        if (x < 0) {
            return false;
        }
        if (x < ten) {
            return true;
        }
        int temp = 0;
        int num = x;
        while (num > 0) {
            temp = temp * ten + (num % ten);
            num /= ten;
        }
        return temp == x;
    }

    /**
     * test case
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Test009 test009 = new Test009();
        System.out.println(test009.isPalindrome3(100));
        System.out.println(test009.isPalindrome3(1));
        System.out.println(test009.isPalindrome3(-1));
        System.out.println(test009.isPalindrome3(99));
        System.out.println(test009.isPalindrome3(345676543));
        System.out.println(test009.isPalindrome3(34566543));
    }
}
