package com.iclazz.something.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * Related Topics
 * 字符串
 *
 * @author yiqunz
 * @date 2022-08-18 15:47
 **/
public class Test014 {

    /**
     * 寻找最小字符串，从左往右比较是否是前缀，不推荐。
     *
     * @param strs String[]
     * @return String
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (null == strs) {
            return prefix;
        }
        int length = strs.length;
        if (length == 0) {
            return prefix;
        }
        if (length == 1) {
            return strs[0];
        }
        String minStr = strs[0];
        String tem;
        for (int i = 1; i < strs.length; i++) {
            tem = strs[i];
            if (null == tem || "".equals(tem)) {
                return prefix;
            }
            if (tem.length() < minStr.length()) {
                minStr = tem;
            }
        }
        String temPrefix;
        for (int i = 0; i < minStr.length(); i++) {
            temPrefix = minStr.substring(0, i + 1);
            for (String str : strs) {
                if (!str.startsWith(temPrefix)) {
                    return prefix;
                }
            }
            prefix = temPrefix;
        }
        return prefix;
    }

    /**
     * 极简子集缩放法，随机选择子集，不断缩小子集范围
     *
     * @param strs String[]
     * @return String
     */
    public String longestCommonPrefix2(String[] strs) {
        for (int i = 1, j = strs[0].length(); i < strs.length; i++) {
            while (!strs[i].startsWith(strs[0])) {
                strs[0] = strs[0].substring(0, --j);
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        Test014 test014 = new Test014();
        String[] strs = new String[]{"ab", "a"};
        String[] strs2 = new String[]{"b", "ac", ""};
        System.out.println(test014.longestCommonPrefix(strs));
        System.out.println(test014.longestCommonPrefix2(strs));
        System.out.println(test014.longestCommonPrefix2(strs2));
    }

}
