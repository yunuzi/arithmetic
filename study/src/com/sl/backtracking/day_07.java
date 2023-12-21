package com.sl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day_07 {

    /**
     * 46. 全排列
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     * @param nums
     * @return
     */
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return res;
    }

    private void backTracking(int[] nums) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == -12){
                continue;
            }
            int temp = nums[i];
            path.add(temp);
            nums[i] = -12;
            backTracking(nums);
            //回溯
            path.removeLast();
            nums[i] = temp;
        }

    }

}
