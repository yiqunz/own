package com.iclazz.something.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy number
 * <p>
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * Related Topics
 * 哈希表
 * 数学
 * 双指针
 * <p>
 * 👍 1048
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-25 09:28
 **/
public class Test202 {

    /**
     * 哈希数组判断是否循环
     * @param n int
     * @return boolean
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 获取下一个拆解的数
     * @param n int
     * @return int
     */
    private int getNext(int n) {
        int totalCount = 0;
        int remainder;
        while (n > 0) {
            remainder = n % 10;
            totalCount += remainder * remainder;
            n /= 10;
        }
        return totalCount;
    }



    /**
     * 快慢指针
     * 我们不是只跟踪链表中的一个值，而是跟踪两个值，称为快跑者和慢跑者。
     *
     * 在算法的每一步中，慢速在链表中前进 1 个节点，快跑者前进 2 个节点（对 getNext(n) 函数的嵌套调用）。
     *
     * 如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
     *
     * 如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
     *
     *
     * @param n int
     * @return boolean
     */
    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


    public static void main(String[] args) {
        System.out.println(new Test202().isHappy(19));
        System.out.println(new Test202().isHappy(4));

    }
}
