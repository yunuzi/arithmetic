/**
 * @author 孙铃
 * @date 2025/3/11 14:32
 */
package com.sl.day;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2012
 * @Date：2025/3/11
 * @Filename：problem_2012
 */
public class problem_2012 {
    /**
     * 2012. 数组美丽值求和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
     *
     * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
     * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
     * 0，如果上述条件全部不满足
     * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
     *
     * 提示：
     *
     * 3 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * @param nums
     * @return
     */
    public int sumOfBeauties(int[] nums) {
        //如果为单调递增，则全部为2
        int res = 0;
        int n = nums.length;
        boolean isIncrease = true;
        for(int i = 0;i < n - 1;i++) {
            if(nums[i] >= nums[i+1]) {
                isIncrease = false;
                break;
            }
        }

        if(isIncrease) {
            System.out.println("isIncrease");
            return 2 * (n - 2);
        }

        int min[] = new int[n];
        min[n-1] = nums[n-1];
        int max[] = new int[n];
        max[0] = nums[0];
        for(int i = 1;i < n;i++) {
            max[i] = Math.max(max[i-1], nums[i]);
        }
        for(int i = n - 2;i >= 0;i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }


        for(int i = 1;i < n - 1;i++) {
            //当满足为1时
            if(nums[i-1] < nums[i] && nums[i] < nums[i+1]) {
                res += 1;
                if(max[i -1] < nums[i] && nums[i] < min[i+1]) {
                    res += 1;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(sumOfBeauties(new int[]{10, 2, 3, 4, 11, 12}));
    }
}
