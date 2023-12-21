package com.sl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class day_05 {


    /**
     * 90. 子集 II
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     *
     *
     * @param nums
     * @return
     */public List<List<Integer>> res = new ArrayList<>();
     public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for(int i = startIndex;i < nums.length;i++){
            //去重操作
            if(i > startIndex  && nums[i] == nums[i -1]){
              continue;
            }
            path.add(nums[i]);
            backTracking(nums,i+1);
            //进行回溯
            path.removeLast();
        }
    }

}
