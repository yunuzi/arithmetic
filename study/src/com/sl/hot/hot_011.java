package com.sl.hot;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_011
 * @Date：2024-3-22 9:30
 * @Filename：hot_011
 */
public class hot_011 {
    /**
     * 239. 滑动窗口最大值
     * 困难
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (k > nums.length){
//            return new int[]{0};
//        }
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int max = nums[i];
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            res[i] = max;
//        }
//        return res;
        //双端队列
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i - deque.getFirst() >= k){
                deque.removeFirst();
            }
            if(i >= k - 1){
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
