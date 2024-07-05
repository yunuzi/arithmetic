package com.sl.arithmeticTrain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_1814
 * @Date：2024-7-5 17:02
 * @Filename：problem_1814
 */
public class problem_1814 {
    /**
     *1814. 统计一个数组中好对子的数目
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ，
     * rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
     *
     * 0 <= i < j < nums.length
     * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])  =====>    nums[i] - rev(nums[i])   =  nums[j] - rev(nums[j])
     * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            int temp = nums[i] - rev(nums[i]);
            if(map.containsKey(temp)){
                res += map.get(temp);
                if(res >= 1000000007){
                    res = res % 1000000007;
                }
            }
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return res;
    }

    public int rev(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();
        for(int i = 0;i<sb.length();i++){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
                i--;
            }else{
                break;
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }


    @Test
    public void test(){
        countNicePairs(new int[]{42,11,1,97});
    }
}
