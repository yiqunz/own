package com.iclazz.something.leetcode.easy;

/**
 * ugly number
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 * Example 1:
 *
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * Example 3:
 *
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 * Related Topics
 * 数学
 *
 * 👍 343
 * 👎 0
 * @author yiqunz
 * @date 2022-09-01 14:20
 **/
public class Test263 {

    /**
     *
     * @param n int
     * @return boolean
     */
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else {
                n /= 5;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Test263().isUgly(6));
        System.out.println(new Test263().isUgly(1));
        System.out.println(new Test263().isUgly(7));
        System.out.println(new Test263().isUgly(14));
        System.out.println(new Test263().isUgly(-2147483648));
    }
}
