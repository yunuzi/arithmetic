package com.sl.Study.DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.Study.DP
 * @Project：arithmetic
 * @name：problem_740
 * @Date：2024-8-7 14:20
 * @Filename：problem_740
 */
public class problem_740 {
    /**
     * 740. 删除并获得点数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums ，你可以对它进行一些操作。
     *
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
     *
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int [] dp = new int[map.size()];
        if(map.size() == 1){
            return map.get(nums[0]) * nums[0];
        }
        dp[0] = map.get(nums[0]) * nums[0];
        int j = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == nums[i-1]+1){
                if(j >= 2){
                    dp[j] = Math.max(dp[j - 1],dp[j -2] + map.get(nums[i]) * nums[i]);
                    j++;
                }else {
                    dp[j] = Math.max(dp[j - 1],map.get(nums[i]) * nums[i]);
                    j++;
                }
            }else {
                dp[j] = dp[j - 1] + map.get(nums[i]) * nums[i];
                j++;
            }
        }
        return dp[dp.length-1];
    }
}
