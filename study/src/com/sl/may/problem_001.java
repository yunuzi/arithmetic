/**
 * @author 孙铃
 * @date 2024/5/12 10:36
 */
package com.sl.may;

import org.junit.Test;

import java.util.*;

/**
 * @author 铃
 * @date 2024/5/12 10:36
 */
public class problem_001 {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        int [] dp = new int[energy.length];
        for(int i = 0;i < k;i++){
            dp[i] = energy[i];
            if(i >= energy.length - k){
                max = Math.max(max,dp[i]);
            }
        }
        for(int i = k;i  < energy.length;i++){
            dp[i] = energy[i];
            dp[i] = Math.max(dp[i],dp[i-k]+energy[i]);
            if(i >= energy.length - k){
                max = Math.max(max,dp[i]);
            }
        }

        List<Integer> list = new ArrayList<>();

//        for(int i = 0;i < list.size();i++)

        Map<Integer,Integer> map = new HashMap<>();
        return max;
    }


    public int getWinner(int[] arr, int k) {
        int step = 0;
        int max = arr[0];
        if(k >= arr.length){
            for(int i = 1;i < arr.length;i++){
                max = Math.max(max,arr[i]);
            }
            return max;
        }
        int arr1 [] = new int[2 * arr.length];
        for(int i = 0;i < arr.length;i++){
            arr1[i] = arr[i];
        }
        for(int i = 0;i < arr1.length - 1;i++){
            if(i + 1 == arr.length - 1){
                return arr1[i] > arr1[i + 1] ? arr1[i] : arr1[i + 1];
            }
            if(arr1[i] > arr1[i + 1]){
                step++;
                if(step == k){
                    return arr1[i];
                }
                arr1[i + arr.length] = arr1[i + 1];
                arr1[i + 1] = arr1[i];
            }else{
                step = 1;
                arr1[i + arr.length] = arr1[i];
            }
        }
        return 0;
    }


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean flage [] = new boolean[queries.length];
        Arrays.fill(flage,true);
        for(int j = 0 ;j < queries.length;j++){
            for(int i = queries[j][0];i < queries[j][1] - 1;i++){
                if((nums[i] + nums[i + 1]) % 2 == 0){
                    flage[j] = false;
                    break;
                }
            }
        }

        return flage;
    }


    public long sumDigitDifferences(int[] nums) {
        int len = nums.length;
        //将int类型的数组转化为字符串数组
        String [] str = new String[len];
        for(int i = 0;i < len;i++){
            str[i] = String.valueOf(nums[i]);
        }
        //记录字符串数组中每个位置上数字的个数
        long res = 0L;
        int [] count = new int[10];
        for(int i = 0;i < str[0].length();i++){
            //一次循环得到每个数字i位置上的数字的个数
            for(int j = 0;j < len;j++){
                count[str[j].charAt(i) - '0']++;
            }
            //累加结果,需要去重
            int k = len;
            for(int j = 0;j < 10;j++){
                k -= count[j];
                res += (long) count[j] * k;
            }
            Arrays.fill(count,0);
        }

        return res;
    }



    @Test
    public void test(){
        System.out.println(sumDigitDifferences(new int[]{13,23,12}));
    }
}
