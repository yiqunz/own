package com.iclazz.something.leetcode.meduim;

/**
 * ugly number
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * Constraints:
 *
 * 1 <= n <= 1690
 * Related Topics
 * 哈希表
 * 数学
 * 动态规划
 * 堆（优先队列）
 *
 * 👍 958
 * 👎 0
 * @author yiqunz
 * @date 2022-09-01 14:42
 **/
public class Test264 {

    /**
     * 动态规划
     * 多指针
     *
     * @param n int
     * @return int
     */
    public int nthUglyNumber(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = array[p2] * 2, num3 = array[p3] * 3, num5 = array[p5] * 5;
            array[i] = Math.min(Math.min(num2, num3), num5);
            if (array[i] == num2) {
                p2++;
            }
            if (array[i] == num3) {
                p3++;
            }
            if (array[i] == num5) {
                p5++;
            }
        }
        return array[n];
    }



    public static void main(String[] args) {
        System.out.println(new Test264().nthUglyNumber(1));
        System.out.println(new Test264().nthUglyNumber(6));
        System.out.println(new Test264().nthUglyNumber(7));
        System.out.println(new Test264().nthUglyNumber(10));
        System.out.println(new Test264().nthUglyNumber(14));
        System.out.println(new Test264().nthUglyNumber(14));
        System.out.println(new Test264().nthUglyNumber(19));
        System.out.println(new Test264().nthUglyNumber(20));
        System.out.println(new Test264().nthUglyNumber(1689));
    }
}
