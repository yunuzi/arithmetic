package com.sl.hot;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_41
 * @Date：2024-8-2 17:35
 * @Filename：hot_41
 */
public class hot_41 {
    /**
     * 41. 缺失的第一个正数
     * 尝试过
     * 困难
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int k = 0;
        int temp = nums[0];
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if(temp <= 0){
                nums[k] = 0;
                temp = nums[i];
                k = i;
            }
            if(0 < temp && temp <= len){
                int temp1 = nums[temp - 1];
                nums[temp - 1] = temp;
                k = temp -1;
                temp = temp1;
            }
        }
        for(int i = 0;i < len;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }
}
