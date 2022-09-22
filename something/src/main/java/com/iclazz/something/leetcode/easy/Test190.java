package com.iclazz.something.leetcode.easy;

/**
 * reverse bots
 * <p>
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
 * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 * <p>
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 * 因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入是一个长度为 32 的二进制字符串
 * <p>
 * <p>
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * 通过次数183,501提交次数257,333
 *
 * @author yiqunz
 * @date 2022-08-24 11:35
 **/
public class Test190 {

    public int reverseBits(int n) {
        //n>=0
        StringBuilder builder = new StringBuilder();
        int tempInt;
        boolean firstIndex = false;
        int zeroCount = 0;
        boolean positiveFlag = n >= 0;
        if (!positiveFlag) {
            n = -n;
        }
        while (n > 0) {
            tempInt = n % 2;
            if (firstIndex || tempInt == 1) {
                builder.append(tempInt);
                firstIndex = true;
            } else {
                zeroCount++;
            }
            n >>= 1;
        }
        String str = builder.reverse().toString();
        int buZero = 32 - str.length() - zeroCount;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int i1 = str.charAt(i) - '0';
            count = (int) (i1 * Math.pow(2, i + buZero) + count);
        }
        return positiveFlag?count:-count;
    }

    /**
     * 方法一：逐位颠倒
     * 思路
     *
     * 将 n 视作一个长为 32 的二进制串，从低位往高位枚举 nn 的每一位，将其倒序添加到翻转结果 \textit{rev}rev 中。
     *
     * 代码实现中，每枚举一位就将 nn 右移一位，这样当前 nn 的最低位就是我们要枚举的比特位。当 n 为 0 时即可结束循环。
     *
     * 需要注意的是，在某些语言（如 \texttt{Java}Java）中，没有无符号整数类型，因此对 nn 的右移操作应使用逻辑右移。
     *
     * @param n int
     * @return int
     */
    public int reverseBits2(int n){
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    /**
     * 01010101010101010101010101010101
     */
    private static final int M1 = 0x55555555;
    /**
     * 00110011001100110011001100110011
     */
    private static final int M2 = 0x33333333;
    /**
     * 00001111000011110000111100001111
     */
    private static final int M4 = 0x0f0f0f0f;
    /**
     * 00000000111111110000000011111111
     */
    private static final int M8 = 0x00ff00ff;

    /**
     * 方法二：位运算分治
     * 思路
     *
     * 若要翻转一个二进制串，可以将其均分成左右两部分，对每部分递归执行翻转操作，然后将左半部分拼在右半部分的后面，即完成了翻转。
     *
     * 由于左右两部分的计算方式是相似的，利用位掩码和位移运算，我们可以自底向上地完成这一分治流程。
     *
     *
     *
     * 对于递归的最底层，我们需要交换所有奇偶位：
     *
     * 取出所有奇数位和偶数位；
     * 将奇数位移到偶数位上，偶数位移到奇数位上。
     * 类似地，对于倒数第二层，每两位分一组，按组号取出所有奇数组和偶数组，然后将奇数组移到偶数组上，偶数组移到奇数组上。以此类推。
     *
     * 需要注意的是，在某些语言（如 \texttt{Java}Java）中，没有无符号整数类型，因此对 nn 的右移操作应使用逻辑右移。
     *
     * @param n int
     * @return int
     */
    public int reverseBit3s(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }



    //运算符、java是如何计算

    public static void main(String[] args) {
        System.out.println(new Test190().reverseBits2(4));
        System.out.println(new Test190().reverseBits(4));
        System.out.println(new Test190().reverseBits(-3));
        System.out.println(new Test190().reverseBits(43261596));
        System.out.println(new Test190().reverseBits2(-3));
        System.out.println(2&1);
        System.out.println(2&3);
        System.out.println(2|3);
        System.out.println(2^3);

    }

}
