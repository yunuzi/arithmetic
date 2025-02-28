/**
 * @author 孙铃
 * @date 2025/2/28 9:21
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2341
 * @Date：2025/2/28
 * @Filename：problem_2341
 */
public class problem_2341 {
    /**
     * 2341. 数组能形成多少数对
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
     *
     * 从 nums 选出 两个 相等的 整数
     * 从 nums 中移除这两个整数，形成一个 数对
     * 请你在 nums 上多次执行此操作直到无法继续执行。
     *
     * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        int count = 0;
        int residue = 0;
        for(int i = 0; i < nums.length; i++) {
            if(arr[nums[i]] == 0) {
                arr[nums[i]] = 1;
            } else {
                count++;
                arr[nums[i]] = 0;
            }
        }
        //求和
        for(int i = 0; i < arr.length; i++) {
            residue += arr[i];
        }
        return new int[]{count,residue};
    }
}
