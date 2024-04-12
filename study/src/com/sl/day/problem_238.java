package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_238
 * @Date：2024-4-8 17:32
 * @Filename：problem_238
 */
public class problem_238 {
    /**
     * 238. 除自身以外数组的乘积
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] pre = new int[len + 1];
        int [] suf = new int[len + 1];
        pre[0] = 1;
        suf[len] = 1;
        for(int i = 0;i < len;i++){
            pre[i + 1] = pre[i] * nums[i];
        }
        for(int i = len - 1;i >= 0;i--){
            suf[i] = suf[i + 1] * nums[i];
        }
        int [] ans = new int[len];
        for(int i = 0;i < len;i++){
            ans[i] = pre[i] * suf[i + 1];
        }
        return ans;
    }
}
