package com.sl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day_04 {


    /**
     * 78. 子集
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * @param nums
     * @return
     */
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        res.add(new LinkedList<>(path));
        for(int i = startIndex;i < nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,i + 1);
            //进行回溯
            path.removeLast();
        }

    }

}
