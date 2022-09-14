package com.iclazz.something.leetcode.medium;

/**
 * longest palindromic substring
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * Related Topics
 * 字符串
 * 动态规划
 * <p>
 * 👍 5680
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-09-14 15:40
 **/
public class Medium005 {


    /**
     * 方法二：中心扩展算法
     * @param s String
     * @return String
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    /**
     * 方法一：动态规划
     * 思路与算法
     *
     * 对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串 \textrm{``ababa''}“ababa”，如果我们已经知道 \textrm{``bab''}“bab” 是回文串，那么 \textrm{``ababa''}“ababa” 一定是回文串，这是因为它的首尾两个字母都是 \textrm{``a''}“a”。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s String
     * @return String
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param s String
     * @return String
     */
    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            String tempStr = s;
            if (result.length() > length - i) {
                break;
            }
            while (tempStr.length() >= i + result.length()) {
                int startIndex = tempStr.lastIndexOf(tempStr.charAt(i));
                if (i == startIndex) {
                    break;
                }
                if (result.length() < startIndex - i + 1) {
                    String substring = tempStr.substring(i, startIndex + 1);
                    if (substring.equals(new StringBuilder(substring).reverse().toString())) {
                        result = substring;
                        if (result.length() >= length - i) {
                            //已获得最长回文
                            break;
                        }
                    }
                }
                tempStr = tempStr.substring(0, startIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Medium005().longestPalindrome("babcab"));
        System.out.println(new Medium005().longestPalindrome("babcacab"));
        System.out.println(new Medium005().longestPalindrome("babacacab"));
        System.out.println(new Medium005().longestPalindrome("cbbbbbd"));
        System.out.println(new Medium005().longestPalindrome("abc"));
    }
}
