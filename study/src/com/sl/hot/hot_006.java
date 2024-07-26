package com.sl.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_006
 * @Date：2024-3-11 10:27
 * @Filename：hot_006
 */
public class hot_006 {
    /**
     * 15. 三数之和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        int right = len - 1;
        for(int i = 0; i < len - 1; i++){
            if (nums[i] > 0) {
                return res;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;

            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

}
