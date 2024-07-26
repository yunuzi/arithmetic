package com.sl.hot;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_004
 * @Date：2024-3-8 17:44
 * @Filename：hot_004
 */
public class hot_004 {
    /**
     * 283. 移动零
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        slow++;
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
        System.out.println(nums);
    }

    @Test
    public void test(){
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
