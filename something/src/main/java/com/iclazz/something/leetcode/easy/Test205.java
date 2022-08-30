package com.iclazz.something.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * isomorphic strings
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * Related Topics
 * 哈希表
 * 字符串
 * <p>
 * 👍 507
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-30 10:27
 **/
public class Test205 {


    /**
     * 双哈希表
     *
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isIsomorphicHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>(s.length());
        Map<Character, Character> tMap = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            Character msc = sMap.get(sc);
            Character mtc = tMap.get(tc);
            if (null == msc && null == mtc) {
                sMap.put(sc, tc);
                tMap.put(tc, sc);
            } else if (null == mtc || null == msc) {
                return false;
            } else if (!sc.equals(mtc) || !tc.equals(msc)) {
                return false;
            }
        }
        return true;
    }

    /**
     * String-api
     *
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isIsomorphicStr(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组法 1ms
     *
     * @param s String
     * @param t String
     * @return boolean
     */
    public boolean isIsomorphic(String s, String t) {
        int indexWord, indexLetter;
        int[] key = new int[128], value = new int[128];
        char[] word = s.toCharArray(), letter = t.toCharArray();
        for (int i = word.length - 1; i >= 0; i--) {
            indexWord = word[i] + 1;
            indexLetter = letter[i] + 1;
            if (key[indexWord] == 0 && value[indexLetter] == 0) {
                key[indexWord] = indexLetter;
                value[indexLetter] = indexWord;
            } else if (key[indexWord] != indexLetter || value[indexLetter] != indexWord) {
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.println(new Test205().isIsomorphic("egg", "add"));
        System.out.println(new Test205().isIsomorphic("foo", "bar"));
        System.out.println(new Test205().isIsomorphic("paper", "title"));
        System.out.println(new Test205().isIsomorphic("badc", "baba"));
    }
}
