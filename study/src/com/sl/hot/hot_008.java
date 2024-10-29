package com.sl.hot;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_008
 * @Date：2024-3-13 19:55
 * @Filename：hot_008
 */
public class hot_008 {

    /**
     * 3. 无重复字符的最长子串
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     *  的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[130];
        int left = 0;
        int res= 0;
        for(int i =0;i<s.length();i++){
            count[s.charAt(i)]++;
            while(count[s.charAt(i)]>1){
                count[s.charAt(left)]--;
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }

}
