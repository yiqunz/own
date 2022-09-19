package com.iclazz.something.leetcode.medium;

/**
 * zigzag conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * Related Topics
 * 字符串
 * <p>
 * 👍 1811
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-09-14 17:53
 **/
public class Medium006 {

    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = numRows * 2 - 2;
        StringBuilder ans = new StringBuilder();
        // 枚举行
        for (int i = 0; i < numRows; i++) {
            // 枚举每个周期的起始索引
            for (int j = 0; j < n - i; j += t) {
                // 当前周期的第一个字符
                ans.append(s.charAt(i + j));
                if (i > 0 && i < numRows - 1 && j + t - i < n) {
                    // 枚举当前周期的第二个字符
                    ans.append(s.charAt(j + t - i));
                }
            }
        }
        return ans.toString();
    }

    public String convert1(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = numRows * 2 - 2;
        int c = (n + t - 1) / t * (numRows - 1);
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

    public String convert2(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = numRows * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < numRows - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }




    public static void main(String[] args) {
        //PAHNAPLSIIGYIR
        System.out.println(new Medium006().convert("PAYPALISHIRING", 4));
        System.out.println(new Medium006().convert("PAYPALISHIRING", 3));
        System.out.println(new Medium006().convert("A", 1));
        System.out.println(new Medium006().convert("AAAAA", 3));
        System.out.println(new Medium006().convert("PAYPALISHIRINGPAYPALISHIRING", 3));
        System.out.println(new Medium006().convert("ABC", 2));
        System.out.println(new Medium006().convert("ABCD", 1));
        System.out.println(new Medium006().convert("ABCD", 2));
    }
}
