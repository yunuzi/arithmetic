package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3090
 * @Date：2024-3-26 16:53
 * @Filename：problem_3090
 */
public class problem_3090 {
    /**
     * 3090. 每个字符最多出现两次的最长子字符串
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该
     * 子字符串
     * 的 最大 长度。
     * @param s
     * @return
     */
    public int maximumLengthSubstring(String s) {
        int [] count = new int[130];
        int left = 0;
        int res = 0;
        for(int i = 0;i < s.length();i++){
            count[s.charAt(i)]++;
            while(count[s.charAt(i)] > 2){
                count[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}
