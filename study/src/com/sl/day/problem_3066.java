/**
 * @author 孙铃
 * @date 2025/3/8 9:44
 */
package com.sl.day;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3066
 * @Date：2025/3/8
 * @Filename：problem_3066
 */
public class problem_3066 {
    /**
     * 3066. 超过阈值的最少操作数 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     *
     * 你可以对 nums 执行一些操作，在一次操作中，你可以：
     *
     * 选择 nums 中 最小 的两个整数 x 和 y 。
     * 将 x 和 y 从 nums 中删除。
     * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
     * 注意，只有当 nums 至少 包含两个元素时，你才可以执行以上操作。
     *
     * 你需要使数组中的所有元素都 大于或等于 k ，请你返回需要的 最少 操作次数。
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        //默认从小到大
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++) {
            queue.add(nums[i]);
        }
        int res = 0;
        while(queue.size() > 1 &&queue.peek()<k) {
            //弹出两个最小值
            int x = queue.poll();
            int y = queue.poll();
            int z = x*2+y;
            if(z > 0) {
                queue.add(z);
            }
            res++;
        }

        if(!queue.isEmpty() && queue.peek() < k) {
            return res + 1;
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {999999999,999999999,999999999};
        minOperations(nums, 1000000000);
    }
}
