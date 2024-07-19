package com.sl.arithmeticTrain;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_3152
 * @Date：2024-7-16 14:10
 * @Filename：problem_3152
 */
public class problem_3152 {
    /**
     * 3152. 特殊数组 II
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
     *
     * 周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助周洋哥检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
     *
     * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean res [] = new boolean[queries.length];
        int check[] = new int[nums.length];
        for(int i = 1;i < nums.length;i++){
            check[i] = check[i-1] + (((nums[i] ^ nums[i - 1]) ^ 1) & 1);
        }
        for(int i = 0;i < queries.length;i++){
            res[i] = check[queries[i][1]] - check[queries[i][0]] == 0;
        }
        return res;
    }
}
