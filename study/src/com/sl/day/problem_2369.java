package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2369
 * @Date：2024-3-1 9:40
 * @Filename：problem_2369
 */
public class problem_2369 {

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
     *
     * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
     *
     * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
     * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
     * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
     * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
     * @param nums
     * @return
     */
    public boolean validPartition(int[] nums) {
//        int n = nums.length;
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        for (int i = 1; i <= n; i++) {
//            if (i >= 2) {
//                dp[i] = dp[i - 2] && validTwo(nums[i - 2], nums[i - 1]);
//            }
//            if (i >= 3) {
//                dp[i] = dp[i] || (dp[i - 3] && validThree(nums[i - 3], nums[i - 2], nums[i - 1]));
//            }
//        }
//        return dp[n];
        int n = nums.length;
        boolean[] dp = new boolean[n + 2];
        dp[0] = true;
        for(int i = 0; i < n - 1; i++){
            if(!dp[i]) continue;
            if(nums[i] == nums[i + 1]){
                dp[i + 2] = true;
                if(i < n - 2 && nums[i + 2] == nums[i + 1]){
                    dp[i + 3] = true;
                }
            }
            if(i < n - 2 && nums[i + 1] == nums[i] + 1 && nums[i + 2] == nums[i] + 2){
                dp[i + 3] = true;
            }
        }
        return dp[n];



    }


    public boolean validTwo(int nums1,int nums2){
        if(nums1 == nums2){
            return true;
        }
        return false;
    }
    public boolean validThree(int nums1,int nums2,int nums3){
        if(nums1 == nums2 && nums2 == nums3){
            return true;
        }
        if(nums1 == nums2 - 1 && nums2 == nums3 - 1){
            return true;
        }
        return false;
    }


}
