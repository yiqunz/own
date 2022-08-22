package com.iclazz.something.leetcode.easy;

/**
 * climbing stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * Constraints:
 * <p>
 * 1 <= n <= 45
 * Related Topics
 * 记忆化搜索
 * 数学
 * 动态规划
 * <p>
 * 👍 2597
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-22 17:09
 **/
public class Test070 {

    /**
     * f(x)=f(x-1)+f(x-2)
     * 方法一：动态规划
     * 思路和算法
     *
     * 我们用 f(x)f(x) 表示爬到第 xx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
     *
     * f(x) = f(x - 1) + f(x - 2)
     * f(x)=f(x−1)+f(x−2)
     *
     * 它意味着爬到第 xx 级台阶的方案数是爬到第 x - 1x−1 级台阶的方案数和爬到第 x - 2x−2 级台阶的方案数的和。很好理解，因为每次只能爬 11 级或 22 级，所以 f(x)f(x) 只能从 f(x - 1)f(x−1) 和 f(x - 2)f(x−2) 转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。
     *
     * 以上是动态规划的转移方程，下面我们来讨论边界条件。我们是从第 00 级开始爬的，所以从第 00 级爬到第 00 级我们可以看作只有一种方案，即 f(0) = 1f(0)=1；从第 00 级到第 11 级也只有一种方案，即爬一级，f(1) = 1f(1)=1。这两个作为边界条件就可以继续向后推导出第 nn 级的正确结果。我们不妨写几项来验证一下，根据转移方程得到 f(2) = 2f(2)=2，f(3) = 3f(3)=3，f(4) = 5f(4)=5，……，我们把这些情况都枚举出来，发现计算的结果是正确的。
     *
     * 我们不难通过转移方程和边界条件给出一个时间复杂度和空间复杂度都是 O(n)O(n) 的实现，但是由于这里的 f(x)f(x) 只和 f(x - 1)f(x−1) 与 f(x - 2)f(x−2) 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成 O(1)O(1)。下面的代码中给出的就是这种实现。
     *
     * @param n int
     * @return int
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     *
     * 方法三：通项公式
     * 思路
     *
     * 之前的方法我们已经讨论了 f(n)f(n) 是齐次线性递推，根据递推方程 f(n) = f(n - 1) + f(n - 2)f(n)=f(n−1)+f(n−2)，我们可以写出这样的特征方程：
     *
     * @param n int
     * @return int
     */
    public int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }



    public static void main(String[] args) {
        System.out.println(new Test070().climbStairs(4));
        System.out.println(new Test070().climbStairs(3));
        System.out.println(new Test070().climbStairs(0));
        System.out.println(new Test070().climbStairs(1));
        System.out.println(new Test070().climbStairs(2));
        System.out.println(new Test070().climbStairs(30));
    }

}
