package com.iclazz.something.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * word pattern
 *
 * @author yiqunz
 * @date 2022-09-05 10:12
 **/
public class Test290 {
    /**
     * 双哈希表
     * @param pattern String
     * @param s String
     * @return boolean
     */
    public boolean wordPattern(String pattern, String s) {
        int pLength = pattern.length();
        String[] wordArray = s.split(" ");
        int wLength = wordArray.length;
        //word number not match
        if (pLength != wLength) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(pLength);
        Map<String, Character> wMap = new HashMap<>(pLength);
        char[] cArray = pattern.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            String s1 = wordArray[i];
            String text = map.get(c);
            Character cc = wMap.get(s1);
            if (null == text && null == cc) {
                map.put(c, s1);
                wMap.put(s1, c);
                continue;
            }
            if (null != text && null != cc) {
                if (!text.equals(s1)) {
                    return false;
                }
                if (c != wMap.get(text)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test290().wordPattern("abc","dog cat dog"));

    }
}
