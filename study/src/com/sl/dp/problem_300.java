/**
 * @author 孙铃
 * @date 2025/4/28 10:54
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_300
 * @Date：2025/4/28
 * @Filename：problem_300
 */
public class problem_300 {
    /**
     * 300. 最长递增子序列
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * @param nums
     * @return
     *提示：
     *
     * 1 <= nums.length <= 2500
     * -10^4 <= nums[i] <= 10^4
     *
     * 进阶：
     *
     * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
     */
    public int lengthOfLIS(int[] nums) {
         //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
         int dp[] = new int[nums.length];
         int res  = 0;
         for(int i = 0; i < nums.length; i++){
             dp[i] = 1;

         }
         if(nums.length == 1){
             return 1;
         }
         for(int  i = 1;i < nums.length; i++){
             for(int j = 0;j < i ;j++){
                 if(nums[i] > nums[j]){
                     dp[i] = Math.max(dp[i],dp[j] + 1);
                 }

             }
             res = Math.max(res,dp[i]);
         }
         return res;

    }
}
