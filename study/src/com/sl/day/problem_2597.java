/**
 * @author 孙铃
 * @date 2025/3/7 9:55
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2597
 * @Date：2025/3/7
 * @Filename：problem_2597
 */
public class problem_2597 {
    /**
     * 2597. 美丽子集的数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个由正整数组成的数组 nums 和一个 正 整数 k 。
     *
     * 如果 nums 的子集中，任意两个整数的绝对差均不等于 k ，则认为该子数组是一个 美丽 子集。
     *
     * 返回数组 nums 中 非空 且 美丽 的子集数目。
     *
     * nums 的子集定义为：可以经由 nums 删除某些元素（也可能不删除）得到的一个数组。只有在删除元素时选择的索引不同的情况下，两个子集才会被视作是不同的子集。
     * @param nums
     * @param k
     * @return
     */
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        dfs(0,n,nums,k,map);
        return res;
    }
    private int res = -1; // 去掉空集

    // nums[i] 选或不选
//    private void dfs(int i, int[] nums, int k, Map<Integer, Integer> cnt) {
//        if (i == nums.length) {
//            ans++;
//            return;
//        }
//        dfs(i + 1, nums, k, cnt); // 不选
//        int x = nums[i];
//        if (cnt.getOrDefault(x - k, 0) == 0 && cnt.getOrDefault(x + k, 0) == 0) { // 可以选
//            cnt.merge(x, 1, Integer::sum); // 选
//            dfs(i + 1, nums, k, cnt); // 讨论 nums[i+1] 选或不选
//            cnt.merge(x, -1, Integer::sum); // 撤销，恢复现场
//        }
//    }

    private void dfs(int i, int n, int[] nums, int k, Map<Integer, Integer> map) {
        if(i == n){
            res++;
            return;
        }
        dfs(i + 1,n,nums,k,map);
        if(map.isEmpty() || !map.containsValue(nums[i])) {
            map.put(i, nums[i] + k);
            dfs(i + 1, n, nums, k, map);
            map.remove(i);
        }

    }

    @Test
    public void test() {
        System.out.println(beautifulSubsets(new int[]{2,4,6}, 2));
    }
}
