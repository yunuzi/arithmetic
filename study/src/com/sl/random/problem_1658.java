/**
 * @author 孙铃
 * @date 2024/10/18 17:27
 */
package com.sl.random;

import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_1658
 * @Date：2024/10/18
 * @Filename：problem_1658
 */
public class problem_1658 {
    /**
     * 1 <= nums.length <= 10……5
     * 1 <= nums[i] <= 10……4
     * 1 <= x <= 10……9
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
//        //前缀和
//        int len = nums.length;
//        int sum = 0;
//        int total = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = Integer.MAX_VALUE;
//        for(int i = 0; i < nums.length; i++){
//            sum += nums[i];
//            total += nums[i];
//            map.put(i + 1,sum);
//        }
//        if(total < x){
//            return -1;
//        }
//        //后缀和
//        Map<Integer, Integer> map1 = new HashMap<>();
//        int sum1 = 0;
//        for(int i = nums.length - 1; i >= 0; i--){
//            sum1 += nums[i];
//            map1.put(sum1,len - i);
//        }
//
//        if(map1.containsKey(x)){
//            res = Math.min(res,map1.get(x));
//        }
//        //前缀和遍历
//        for(int i = 0; i < nums.length; i++){
//            int temp = x - map.get(i + 1);
//            if(temp < 0){
//                break;
//            }
//            if(temp == 0){
//                res = Math.min(res,i + 1);
//            }
//            if(temp > 0){
//                if(map1.containsKey(temp)){
//                    int t = map1.get(temp);
//                    res = Math.min(res,i + 1 + t);
//                }
//            }
//        }
//
//        return res == Integer.MAX_VALUE ? -1 : res;

        int sum=0,tar=0,left=0,len=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            tar+=nums[i];
        }

        if(tar-x<0) return -1;

        //len代表中间那一段的最大长度
        for(int right=0;right<n;right++){
            //进窗口
            sum+=nums[right];
            //判断
            while(sum>tar-x){
                //出窗口
                sum-=nums[left];
                left++;
            }
            //更新结果
            if(sum==tar-x){
                len=Math.max(len,right-left+1);
            }
        }
        if(len==-1) return len;
        else return n-len;
    }

    @Test
    public void test(){



        minOperations(new int[]{5,2,3,1,1},5);
    }
}
