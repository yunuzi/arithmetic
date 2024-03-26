package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2864
 * @Date：2024-3-13 9:18
 * @Filename：problem_2864
 */
public class problem_2864 {
    /**
     * 2864. 最大二进制奇数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
     *
     * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
     *
     * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
     *
     * 注意 返回的结果字符串 可以 含前导零。
     * @param s
     * @return
     */
    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int ones = 0;
        int slow = 0;
        int fast = 0;
        for(;fast < charArray.length;fast++){
            if(charArray[fast] == '1'){
                charArray[slow] = charArray[fast];
                slow++;
            }
        }
        slow = slow - 1;
        for(;slow < charArray.length;slow++){
            charArray[slow] = '0';
            if(slow == charArray.length - 1){
                charArray[slow] = '1';
            }
        }
        return String.valueOf(charArray);
    }
}
