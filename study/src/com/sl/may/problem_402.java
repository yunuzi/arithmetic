/**
 * @author 孙铃
 * @date 2024/6/16 10:26
 */
package com.sl.may;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 铃
 * @date 2024/6/16 10:26
 */
public class problem_402 {

    public int countCompleteDayPairs(int[] hours) {
        int res = 0;
        for(int i =0;i < hours.length;i++){
            for(int j = i+1;j < hours.length;j++){
                long sum = hours[i] + hours[j];
                if(sum % 24 == 0){
                    res++;
                }
            }
        }
        return res;
    }


    public long countCompleteDayPairs1(int[] hours) {
        long res = 0;
        int counts [] = new int[24];
        for(int i= 0;i < hours.length;i++){
            hours[i] = hours[i] % 24;
            counts[hours[i]]++;
        }
        for(int i = 0;i <= 12;i++){
            if(i == 0){
                //
                res += (long) counts[i] * (counts[i] - 1) / 2;
            } else if (i == 12) {
                res += (long) counts[i] * (counts[i] - 1) / 2;
            }  else {
                res += (long) counts[i] * counts[24 - i];
            }
        }
        return res;

//        Map<Integer, Integer> complementCount = new HashMap<>();
//        complementCount.put(0, 1); // 初始化
//        long count = 0;
//
//        for (int hour : hours) {
//            int complement = (24 - hour % 24) % 24; // 确保complement在0~23范围内
//            count += complementCount.getOrDefault(complement, 0);
//            complementCount.put(hour % 24, complementCount.getOrDefault(hour % 24, 0) + 1);
//        }
//        return count;
    }


    public long maximumTotalDamage(int[] power) {
        long res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < power.length;i++){
            if(map.containsKey(power[i])){
                map.put(power[i],map.get(power[i]) + 1);
            }else {
                map.put(power[i],1);
            }
        }
        int [] arr = new int[map.size()];
        int k = 0;
        for(int i : map.keySet()){
            arr[k] = i;
            k++;
        }
        Arrays.sort(arr);
        long [] dp = new long[arr.length];
        dp[0] = (long) arr[0] * map.get(arr[0]);
        for(int i = 1;i < arr.length;i++){
            int x = -1;
            int left = 0, right = i - 1;
            int target = arr[i] - 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= target) {
                    x = mid;
                    right = mid - 1; // 在左半部分继续寻找更小的满足条件的索引
                } else {
                    left = mid + 1; // 否则在右半部分查找
                }
            }

            if(x == -1){//都小于
                dp[i] = (long) arr[i] * map.get(arr[i]) + dp[i - 1];
            }else {//最小的大于 x
                dp[i] =Math.max(dp[i -1], x - 1 >=0 ? dp[x - 1] + (long) arr[i] * map.get(arr[i]) : (long) arr[i] * map.get(arr[i]));
            }
        }
        return dp[arr.length - 1];

    }


    public int maxHeightOfTriangle(int red, int blue) {
        int m = Math.max(red, blue);
        int n = Math.min(red, blue);
        int h = 0;
        for (int i = 1; i <= m; i++){
            if(i % 2 == 1){
                n = n - i;
            }else {
                m = m - i;
            }
            if(m < 0 || n < 0){
                break;
            }
            h++;
        }
        int h2 = 0;
        int x = Math.max(red, blue);
        int y = Math.min(red, blue);
        for(int i = 1;i <= x;i++){
            if(i % 2 == 1){
                x = x - i;
            }else {
                y = y - i;
            }
            if(x < 0 || y < 0){
                break;
            }
            h2++;
        }
        return Math.max(h,h2);
    }

    public int maximumLength(int[] nums) {
        int res = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;
        int len = nums.length;
        if (len == 2){
            return 2;
        }
        int x = 0;
        int y = 0;
        for(int i = 0;i < len;i++){
            if(nums[i] % 2 == 0){
                res4++;
            }else {
                res3++;
            }
            if(x % 2 == 0 && nums[i] % 2 == 0){
                res++;
                x++;
            }else if(x % 2 == 1 && nums[i] % 2 == 1){
                res++;
                x++;
            }
            if(y % 2 == 0 && nums[i] % 2 == 1){
                res2++;
                y++;
            }else if(y % 2 == 1 && nums[i] % 2 == 0){
                res2++;
                y++;
            }
        }
        return Math.max(res,Math.max(res2,Math.max(res3,res4)));
    }

    public int maximumLength(int[] nums, int k) {
        int arr [] = new int[k];
        int len = nums.length;
        if (len == 2){
            return 2;
        }
        for(int i = 0;i < len;i++){
            nums[i] = nums[i] % k;
        }
        for(int i = 0;i < k;i++){
            for(int j = 0;j < len - 1;j++){
                int x = j;
                int y = j + 1;
                while((nums[x] + nums[y]) % k  != i){
                    y++;
                    if(y >= len){
                        break;
                    }
                }
                if(y < len){
                    arr[i]++;
                }
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }


    @Test
    public void test(){
        int arr[] = new int[]{1,4,2,3,1,4};
        long i = maximumLength(arr,3);
        System.out.println(i);
    }


}
