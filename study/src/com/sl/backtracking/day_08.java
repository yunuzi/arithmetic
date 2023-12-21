package com.sl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class day_08 {

    /**
     * 47. 全排列 II
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums);
        return res;
    }

    private void backTracking(int[] nums) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //给已经被选择了的值去重
            if(nums[i] == -12){
                continue;
            }
            //纵向去重
            if(i > 0 && (nums[i] == nums[i-1])){
                continue;
            }
            path.add(nums[i]);
            //给选中的值标记
            nums[i] = -12;
             backTracking(nums);
             //进行回溯操作
            nums[i] = path.removeLast();
        }
    }

}
