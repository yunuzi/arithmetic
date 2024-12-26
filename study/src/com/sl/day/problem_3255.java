/**
 * @author 孙铃
 * @date 2024/11/6 20:25
 */
package com.sl.day;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3255
 * @Date：2024/11/6
 * @Filename：problem_3255
 */
public class problem_3255 {
    public int[] resultsArray(int[] nums, int k) {
        int n  = nums.length;
        if(n == 1) {
            return new int[]{nums[0]};
        }
        int [] res = new int[n-k+1];
        Arrays.fill(res,-1);
        int pre = nums[0];
        int left = 0;
        int temp = 1;
        for(int i = 1; i < n; i++) {
            if(temp >= k) {
                res[i - k] = nums[i -1];
                pre = nums[i -1];
            }
            if(nums[i] - 1 == pre) {
                temp++;
                pre = nums[i];
            }else {
                temp = 1;
                pre = nums[i];
            }
        }
        if(temp >= k) {
            res[n - k] = nums[n - 1];
        }
        return res;
    }
}
