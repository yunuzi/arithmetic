/**
 * @author 孙铃
 * @date 2024/11/25 9:53
 */
package com.sl.arithmeticTrain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_3364
 * @Date：2024/11/25
 * @Filename：problem_3364
 */
public class problem_3364 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        return 0;

    }

    @Test
    public void test() {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(-2);
        nums.add(1);
        nums.add(4);
        int l = 2;
        int r = 3;
        int result = minimumSumSubarray(nums, l, r);
        System.out.println(result);
    }
}
