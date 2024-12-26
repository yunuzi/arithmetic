/**
 * @author 孙铃
 * @date 2024/11/1 13:48
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1493
 * @Date：2024/11/1
 * @Filename：problem_1493
 */
public class problem_1493 {

    /**
     * 1493. 删掉一个元素以后全为 1 的最长子数组
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int l=0;
        int ans=0;
        int cnt0=0;
        for(int r=0;r<nums.length;r++){
            cnt0+=1-nums[r];
            if(cnt0>1){
                cnt0-=1-nums[l++];
            }
            ans = Math.max(ans,r-l);
        }
        return ans;
    }
}
