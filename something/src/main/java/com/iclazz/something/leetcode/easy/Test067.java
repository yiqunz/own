package com.iclazz.something.leetcode.easy;

/**
 * add binary
 *
 * @author yiqunz
 * @date 2022-08-22 10:40
 **/
public class Test067 {
    /**
     * 二进制转十进制处理
     * 支持的位数太少了
     *
     * @param a String
     * @param b String
     * @return String
     */
    public String addBinary(String a, String b) {
        long sumInt = Long.parseLong(a) + Long.parseLong(b);
        int digits = 0;
        StringBuilder result = new StringBuilder();
        long temp;
        if (sumInt == 0) {
            return String.valueOf(sumInt);
        }
        while (sumInt > 0 || digits == 1) {
            temp = sumInt % 10 + digits;
            digits = 0;
            sumInt /= 10;
            if (temp > 1) {
                temp = temp % 2;
                digits = 1;
            }
            result.insert(0, temp);
        }
        return result.toString();
    }

    /**
     * 位数相加，判断是否进位
     *
     * @param a String
     * @param b String
     * @return String
     */
    public String addBinary2(String a, String b) {
        String longStr = a.length() > b.length() ? a : b;
        String shortStr = a.length() > b.length() ? b : a;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = longStr.length() - 1, y = shortStr.length() - 1; i >= 0; i--, y--) {
            carry += longStr.charAt(i) - '0';
            if (y >= 0) {
                carry += shortStr.charAt(y) - '0';
            }
            builder.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new Test067().addBinary2("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"));
        System.out.println(new Test067().addBinary2("1", "1"));
        System.out.println(new Test067().addBinary2("0", "0"));
        System.out.println(new Test067().addBinary("1", "1"));
        System.out.println(new Test067().addBinary("0", "0"));
    }
}
