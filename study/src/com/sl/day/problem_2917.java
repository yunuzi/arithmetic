package com.sl.day;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2917
 * @Date：2024-3-6 14:21
 * @Filename：problem_2917
 */
public class problem_2917 {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < 31; i++){
            int count = 0;
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    count++;
                }
                if(count % k == 0){
                    res |= (1 << i);
                    break;
                }
            }
        }
        return res;
    }

}
