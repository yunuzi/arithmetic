/**
 * @author 孙铃
 * @date 2025/4/28 14:32
 */
package com.sl.dp;

import java.util.HashMap;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_1027
 * @Date：2025/4/28
 * @Filename：problem_1027
 */
public class problem_1027 {
    /**
     * 1027. 最长等差数列
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
     *
     * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,6,9,12]
     * 输出：4
     * 解释：
     * 整个数组是公差为 3 的等差数列。
     * 示例 2：
     *
     * 输入：nums = [9,4,7,2,10]
     * 输出：3
     * 解释：
     * 最长的等差子序列是 [4,7,10]。
     * 示例 3：
     *
     * 输入：nums = [20,1,15,3,10,5,8]
     * 输出：4
     * 解释：
     * 最长的等差子序列是 [20,15,10,5]。
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 1000
     * 0 <= nums[i] <= 500
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
//        int res = 1;
//        int min = 0;
//        int max = 500;
//        for(int i = 0;i < nums.length;i++) {
//            min = Math.min(min,nums[i]);
//            max = Math.max(max,nums[i]);
//        }
//        int difference = max - min;
//        for(int i = -difference;i <= difference;i++) {
//            res = Math.max(res,longestSubsequence(nums,i));
//        }
//        return res;

        //优解
        int max_length=0;
        int max_num=0;
        for(int num:nums){
            max_num=Math.max(max_num,num);
        }
        for(int d=-max_num;d<=max_num;d++){
            int[]f=new int[max_num+1];
            for(int num:nums){
                f[num]=0<=num-d&&num-d<=max_num?f[num-d]+1:1;
                max_length=Math.max(max_length,f[num]);
            }
        }
        return max_length;
    }

    public int longestSubsequence(int[] arr, int difference) {//跟300题一样，只是需要记录最长子序列的长度
        // 使用 HashMap 优化时间复杂度
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = 1;

        for (int num : arr) {
            int prevNum = num - difference;
            int currentLength = dp.getOrDefault(prevNum, 0) + 1;
            dp.put(num, currentLength);
            res = Math.max(res, currentLength);
        }

        return res;
    }
}
