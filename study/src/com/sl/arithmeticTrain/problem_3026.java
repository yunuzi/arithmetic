/**
 * @author 孙铃
 * @date 2024/10/7 19:49
 */
package com.sl.arithmeticTrain;

/**
 * @author sl
 * @date 2024/10/7 19:49
 */
public class problem_3026 {
    /**
     * 3026. 最大好子数组和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个长度为 n 的数组 nums 和一个 正 整数 k 。
     *
     * 如果 nums 的一个
     * 子数组
     * 中，第一个元素和最后一个元素 差的绝对值恰好 为 k ，我们称这个子数组为 好 的。换句话说，如果子数组 nums[i..j] 满足 |nums[i] - nums[j]| == k ，那么它是一个好子数组。
     *
     * 请你返回 nums 中 好 子数组的 最大 和，如果没有好子数组，返回 0 。
     * @param nums
     * @param k
     * @return
     */
    public long maximumSubarraySum(int[] nums, int k) {
        int []sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            sum[i] += nums[i];
        }

//        for(int i = 1;i < nums.length;i++){
//            for(int j = 0;j < i;j++){
//                if(nums[i] - sum[j] == k || )
//            }
//        }

        return 0;
    }

}
