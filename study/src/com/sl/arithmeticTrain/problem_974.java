package com.sl.arithmeticTrain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_974
 * @Date：2024-7-19 14:06
 * @Filename：problem_974
 */
public class problem_974 {
    /**
     * 974. 和可被 K 整除的子数组
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
     *
     * 子数组 是数组中 连续 的部分。
     * @param nums
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : nums) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
