package com.sl.arithmeticTrain;

import java.util.HashMap;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2342
 * @Date：2024-7-2 14:13
 * @Filename：problem_2342
 */
public class problem_2342 {

    /**
     * 2342. 数位和相等数对的最大和
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
     *
     * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
     * @param nums
     * @return
     */
    public int maximumSum(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int res = -1;
//        for(int i = 0;i < nums.length;i++){
//           int x = sumInt(nums[i]);
//           if(map.containsKey(x)){
//               res = Math.max(res,nums[i] + map.get(x));
//           }
//           map.put(x,Math.max(map.getOrDefault(x,0),nums[i]));
//        }
//        return res;
        int ans = -1;
        int[] mx = new int[82]; // 至多 9 个 9 相加
        for (int num : nums) {
            int s = 0; // num 的数位和
            for (int x = num; x > 0; x /= 10) { // 枚举 num 的每个数位
                s += x % 10;
            }
            if (mx[s] > 0) { // 说明左边也有数位和等于 s 的元素
                ans = Math.max(ans, mx[s] + num); // 更新答案的最大值
            }
            mx[s] = Math.max(mx[s], num); // 维护数位和等于 s 的最大元素
        }
        return ans;
    }

    public int sumInt(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
