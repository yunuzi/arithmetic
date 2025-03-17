/**
 * @author 孙铃
 * @date 2025/3/17 11:58
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_1963
 * @Date：2025/3/17
 * @Filename：problem_1963
 */
public class problem_1963 {
    /**
     * 1963. 使字符串平衡的最小交换次数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
     *
     * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
     *
     * 字符串是一个空字符串，或者
     * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
     * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
     * 你可以交换 任意 两个下标所对应的括号 任意 次数。
     *
     * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        char[] charArray = s.toCharArray();

        int res = 0;
        for(int i = 0;i < charArray.length;i++) {
            if(charArray[i] == '[' || res == 0) {
                res++;
            }else {
                res--;
            }
        }

        return res / 2;
    }
}


