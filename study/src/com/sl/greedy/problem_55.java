package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_55
 * @Date：2023-12-18 13:34
 * @Filename：problem_55
 */
public class problem_55 {
    /**
     * 55. 跳跃游戏
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int jumpMax = 0;
        int len = nums.length - 1;
        for(int i = 0;i <= jumpMax;i++){
            //当前可跳跃的最大范围
            jumpMax = (i + nums[i]) > jumpMax ? i + nums[i] : jumpMax;
            if(jumpMax >= len){
                return true;
            }
        }
        return false;
    }


}
