package com.sl.day;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2834
 * @Date：2024-3-8 9:22
 * @Filename：problem_2834
 */
public class problem_2834 {
    /**
     * 2834. 找出美丽数组的最小和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个正整数：n 和 target 。
     *
     * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
     *
     * nums.length == n.
     * nums 由两两互不相同的正整数组成。
     * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
     * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
     *
     *
     * @param n
     * @param target
     * @return
     */
    public int minimumPossibleSum(int n, int target) {
//        int result = 0;
//        HashMap<Integer,Integer> map = new HashMap();
//        map.put(target - 0,1);
//        int j = 1;
//        while(map.size() < n){
//            while(map.size() < n && !map.containsKey(j)){
//                if(result >= 1000000007){
//                    result = result % 1000000007;
//                }
//                result += j;
//                map.put(target - j,j);
//                j++;
//            }
//            j++;
//        }
//        return result % 1000000007;
        int mid = target / 2 + 1;
        int result = 0;
        if(n < mid){
            for(int i = 0; i < n; i++){
                result += i;
            }
            return result % 1000000007;
        }
        int out = n - mid + 1;
        return (mid - 1 * (mid) / 2  + target * out +  out * out /  2) % 1000000007;
     }

    @Test
    public  void test(){
        minimumPossibleSum(2,3);
    }

}
