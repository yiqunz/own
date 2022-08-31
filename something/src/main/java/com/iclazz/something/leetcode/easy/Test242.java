package com.iclazz.something.leetcode.easy;

import java.util.Arrays;

/**
 * valid anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * <p>
 * Related Topics
 * 哈希表
 * 字符串
 * 排序
 * <p>
 * 👍 649
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-31 16:35
 **/
public class Test242 {
    /**
     * Arrays-Api
     *
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //简单数组排序
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }


    /**
     * 粗暴排序法
     *
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //简单数组排序
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        int i = 0;
        for (char c : sArr) {
            if (c != tArr[i++]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组下标法
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] array = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            array[sArr[i] - 97] += 1;
            array[tArr[i] - 97] -= 1;
        }
        for (int i : array) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Test242().isAnagram2("anagram", "nagaram"));
        System.out.println(new Test242().isAnagram2("cat", "dog"));
    }

}
