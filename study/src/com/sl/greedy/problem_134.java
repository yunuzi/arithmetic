package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_134
 * @Date：2023-12-18 17:14
 * @Filename：problem_134
 */
public class problem_134 {
    /**
     *134. 加油站
     * 中等
     * 相关标签
     * 相关企业
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     *
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i =0;i < gas.length;i++){
            sum += gas[i] -cost[i];
        }
        if(sum < 0){
            return -1;
        }
        sum = 0;
        int startIndex = 0;
        for(int i = 0;i < gas.length;i++){
            sum = sum + gas[i] - cost[i];
            if(sum < 0){
                startIndex = i + 1;
                sum = 0;
            }
        }
        return startIndex;
    }
}
