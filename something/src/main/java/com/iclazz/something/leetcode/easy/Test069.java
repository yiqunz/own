package com.iclazz.something.leetcode.easy;

/**
 * sqrt(x)
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * Constraints:
 * <p>
 * 0 <= x <= 231 - 1
 * Related Topics
 * 数学
 * 二分查找
 * <p>
 * 👍 1120
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-22 14:26
 **/
public class Test069 {
    /**
     * 暴力法
     * 不推荐
     *
     * @param x int
     * @return int
     */
    public int mySqrt(int x) {
        //negative compute
        int times = 1;
        int temp = x;
        while (temp / 2 >= times * 2) {
            temp /= 2;
            times *= 2;
        }
        int result = times;
        for (int i = times; i < 2 * times; i++) {
            result = i;
            if (i * i == x) {
                break;
            } else if (i * i > x || i * i < 0) {
                result = i - 1;
                break;
            }
        }
        return result;
    }

    /**
     * 二分法
     * 注意int的取值范围
     *
     * @param x int
     * @return int
     */
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Test069().mySqrt(4));
        System.out.println(new Test069().mySqrt(183692038));
        System.out.println(new Test069().mySqrt(2147483647));
        System.out.println(new Test069().mySqrt(8192));
        System.out.println(new Test069().mySqrt(8));
        System.out.println(new Test069().mySqrt(1));
        System.out.println(new Test069().mySqrt(0));
        System.out.println(new Test069().mySqrt(64));
        System.out.println(new Test069().mySqrt(127));
        System.out.println(new Test069().mySqrt(128));
        System.out.println(new Test069().mySqrt(129));
        System.out.println(new Test069().mySqrt(256));

        System.out.println(new Test069().mySqrt2(4));
        System.out.println(new Test069().mySqrt2(183692038));
        System.out.println(new Test069().mySqrt2(2147483647));
        System.out.println(new Test069().mySqrt2(8192));
        System.out.println(new Test069().mySqrt2(8));
        System.out.println(new Test069().mySqrt2(1));
        System.out.println(new Test069().mySqrt2(0));
        System.out.println(new Test069().mySqrt2(64));
        System.out.println(new Test069().mySqrt2(127));
        System.out.println(new Test069().mySqrt2(128));
        System.out.println(new Test069().mySqrt2(129));
        System.out.println(new Test069().mySqrt2(256));
    }
}
