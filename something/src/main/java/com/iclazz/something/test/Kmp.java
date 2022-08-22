package com.iclazz.something.test;

/**
 * KMP
 *
 * @author yiqunz
 * @date 2022-08-19 16:44
 **/
public class Kmp {
    private final int[][] dp;
    private final String pat;


    public Kmp(String pat) {
        this.pat = pat;
        int m = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[m][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int x = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < m; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[x][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            x = dp[x][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == m) {
                return i - m + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}
