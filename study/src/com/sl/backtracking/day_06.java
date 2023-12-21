package com.sl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day_06 {


    /**
     * 491. 递增子序列
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     *
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     *
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public Boolean flg = true;
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        if(path.size() >=2){
            res.add(new ArrayList<>(path));
        }
        for(int i = startIndex;i < nums.length;i++){
            //去重操作
            if(i > startIndex){
                flg = true;
                for(int j = startIndex;j < i;j++){
                    if(nums[j] == nums[i]){
                        flg = false;
                    }
                }
                if(!flg){
                    continue;
                }
            }
            //判断是否加入path
            if(path.size() > 0){
                if(path.getLast() <= nums[i]){
                    path.add(nums[i]);
                    backTracking(nums,i+1);
                    //进行回溯
                    path.removeLast();
                }
            }
            if(path.size() == 0){
                path.add(nums[i]);
                backTracking(nums,i+1);
                //进行回溯
                path.removeLast();
            }


        }
    }
}
