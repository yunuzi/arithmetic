package com.sl.hot;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_007
 * @Date：2024-3-11 11:09
 * @Filename：hot_007
 */
public class hot_007 {

    /**
     * 42. 接雨水
     * 困难
     * 相关标签
     * 相关企业
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height
     * @return
     */
    public int trap(int[]  height) {
        int left = 1;
        int right = height.length - 2;
        int max_left = 0;
        int max_right = 0;
        int sumTrap = 0;
        for(int i = 1;i < height.length - 1;i++){
            if(height[left - 1] < height[right + 1]){
                max_left = Math.max(max_left,height[left - 1]);
                if(max_left > height[left]){
                    sumTrap += max_left - height[left];
                }
                left++;
            } else{
                max_right = Math.max(max_right,height[right + 1]);
                if(max_right > height[right]){
                    sumTrap += max_right - height[right];
                }
                right--;
            }
        }
        return sumTrap;
    }
}
