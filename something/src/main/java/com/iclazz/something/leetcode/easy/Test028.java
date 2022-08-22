package com.iclazz.something.leetcode.easy;

/**
 * implement strStr
 *
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * Related Topics
 * 双指针
 * 字符串
 * 字符串匹配
 *
 * 👍 1555
 * 👎 0
 * @author yiqunz
 * @date 2022-08-19 15:29
 **/
public class Test028 {
    /**
     * JAVA String.indexOf() api就能完美解决
     * @param haystack String
     * @param needle String
     * @return int
     */
    public int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle) || null == haystack || "".equals(haystack)) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    /**
     * 手写双指针匹配字符串字符
     * @param haystack String
     * @param needle String
     * @return int
     */
    public int strStr2(String haystack, String needle) {
        if (null == needle || "".equals(needle) || null == haystack || "".equals(haystack)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int q = 0;
        char[] hCharArray = haystack.toCharArray();
        char[] nCharArray = needle.toCharArray();
        int p;
        while (q <= hCharArray.length - nCharArray.length) {
            p = 0;
            while (hCharArray[q+p] == nCharArray[p]) {
                if (p == nCharArray.length - 1) {
                    return q;
                }
                p++;
            }
            q++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test028 test028 = new Test028();
        System.out.println(test028.strStr2("mississippi","mississippi"));
    }


}
