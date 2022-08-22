package com.iclazz.something.leetcode.easy;

/**
 * length of last word
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * Related Topics
 * 字符串
 *
 * 👍 485
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-22 09:25
 **/
public class Test058 {
    /**
     * 利用String的api-split进行处理
     * @param s String
     * @return int
     */
    public int lengthOfLastWord(String s) {
        if (null == s) {
            return 0;
        }
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    /**
     * 利用String的api-lastIndexOf进行处理
     * @param s String
     * @return int
     */

    public int lengthOfLastWord2(String s) {
        if (null == s) {
            return 0;
        }
        s = s.trim();
        return s.length() -s.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Test058().lengthOfLastWord("hello world"));
        System.out.println(new Test058().lengthOfLastWord2("hello world"));
        System.out.println(new Test058().lengthOfLastWord2("  fly me   to   the moon  "));
    }
}
