package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1752
 * @Date：2024-7-26 11:01
 * @Filename：problem_1752
 */
public class problem_1752 {
    /**
     * 1672. 最富有客户的资产总量
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     *
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int i = 0;i< accounts.length;i++){
            int money = 0;
            for(int j = 0;j < accounts[0].length;j++){
                money += accounts[i][j];
            }
            res =Math.max(res,money);
        }
        return res;
    }
}
