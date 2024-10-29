package com.sl.hot;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_005
 * @Date：2024-3-11 10:10
 * @Filename：hot_005
 */
public class hot_005 {
    /**
     * 11. 盛最多水的容器
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            //给max赋值
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            //判断往那边移动
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
