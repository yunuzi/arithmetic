/**
 * @author 孙铃
 * @date 2024/12/2 16:04
 */
package com.raceWeek;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.raceWeek
 * @Project：arithmetic
 * @name：race_426
 * @Date：2024/12/2
 * @Filename：race_426
 */
public class race_426 {

    /**
     * 3370. 仅含置位位的最小整数
     * 简单
     * 相关企业
     * 提示
     * 给你一个正整数 n。
     *
     * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
     *
     * 置位 位指的是二进制表示中值为 1 的位。
     * @param n
     * @return
     */

    public int smallestNumber(int n) {
        int [] arr = new int[10];
        arr[0] = 1;
        int k = 1;
        for(int i = 1;i < 10;i++) {
            k = k * 2;
            arr[i] = k + arr[i - 1];
        }

        for(int i = 0;i < 10;i++) {
            if(n <= arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 3371. 识别数组中的最大异常值
     * 中等
     * 相关企业
     * 提示
     * 给你一个整数数组 nums。该数组包含 n 个元素，其中 恰好 有 n - 2 个元素是 特殊数字 。剩下的 两个 元素中，一个是这些 特殊数字 的 和 ，另一个是 异常值 。
     *
     * 异常值 的定义是：既不是原始特殊数字之一，也不是表示这些数字元素和的数字。
     *
     * 注意，特殊数字、和 以及 异常值 的下标必须 不同 ，但可以共享 相同 的值。
     *
     * 返回 nums 中可能的 最大异常值。
     * @param nums
     * @return
     */
    public int getLargestOutlier(int[] nums) {
        return 0;
    }

    @Test
    public void test() {
        System.out.println(smallestNumber(15));
    }
}
