package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_376
 * @Date：2023-12-18 13:11
 * @Filename：problem_376
 */
public class problem_376 {
    /**
     * 376. 摆动序列
     * 中等
     * 1.1K
     * 相关企业
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     *
     * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
     *
     * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     *
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int count = 1;
        //上一个差值
        int pre = 0;
        //当前差值
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            current = nums[i] - nums[i-1];
            if((current > 0 && pre <=0) || (current < 0 && pre >=0)){
                count++;
                pre = current;
            }
        }
        return count;
    }
}
