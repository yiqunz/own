package com.iclazz.something.leetcode.easy;

/**
 * power of two
 * <p>
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * <p>
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: false
 * Constraints:
 * <p>
 * -2^31 <= n <= 2^31 - 1
 * Follow up: Could you solve it without loops/recursion?
 * Related Topics
 * 位运算
 * 递归
 * 数学
 * <p>
 * 👍 532
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-25 16:25
 **/
public class Test231 {

    /**
     * n & (n - 1)==0
     *
     * @param n int
     * @return boolean
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * (n & -n) == n
     * <p>
     * 000...0001
     * 111...1111
     * 000...0011
     * 111...1101
     *
     * @param n int
     * @return boolean
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }

    /**
     * 1<<30 取余数
     *
     * @param n int
     * @return boolean
     */
    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (1 << 30) % n == 0;
    }


    public static void main(String[] args) {
        System.out.println(new Test231().isPowerOfTwo3(-8));
        System.out.println(new Test231().isPowerOfTwo3(1));
        System.out.println(new Test231().isPowerOfTwo3(3));
        System.out.println(new Test231().isPowerOfTwo3(4));
        System.out.println(new Test231().isPowerOfTwo3(5));
    }
}
