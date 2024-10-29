package com.sl.arithmeticTrain;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_1542
 * @Date：2024-9-12 12:24
 * @Filename：problem_1542
 */
public class problem_1542 {
    /**
     * 1524. 和为奇数的子数组数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
     *
     * 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int [] pre = new int[n];
        int [] preSum = new int[n];
        int sum = 0;
        //求出前缀和
        for(int i = 0;i < n;i++){
            int total = 0;
            if(i == 0){
                pre[i] = arr[i];
            }else {
                pre[i] = pre[i-1] + arr[i];
            }
            if(pre[i] % 2 == 1){
                if(i == 0){
                    preSum[i] = 1;
                }else {
                    preSum[i] = preSum[i-1] + 1;
                }
            }else{
                if(i == 0){
                    preSum[i] = 0;
                }else {
                    preSum[i] = preSum[i-1];
                }
            }
            if(i == 0){
                total += preSum[i];
            }else {
                if(preSum[i-1] == preSum[i]){//说明为偶数  偶数 - 奇数 = 奇数  求奇数的数量
                    total += preSum[i];
                }else { //奇数 - 偶数 = 奇数  求偶数的数量  还要加上自身
                    total += i + 1 - preSum[i] + 1;
                }
            }
            if(sum >= 1000000007){
                sum = sum % 1000000007;
            }
            sum += total;
        }
        return sum;
    }
}
