package com.sl.arithmeticTrain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：poeblem_1010
 * @Date：2024-7-3 11:19
 * @Filename：poeblem_1010
 */
public class poeblem_1010 {
    /**
     * 1010. 总持续时间可被 60 整除的歌曲
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     *
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
//        int count = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(0,0);
//        for(int i=0;i < time.length;i++){
//            time[i] = time[i] % 60;
//            if(map.containsKey(time[i]) || time[i] == 0){
//                count += map.get(time[i]);
//            }
//            if(time[i] != 0){
//                map.put(60 - time[i],map.getOrDefault(60 - time[i],0) + 1);
//            }
//            if(time[i] == 0){
//                map.put(0,map.getOrDefault(0,0) + 1);
//            }
//        }
//        return count;
        long[] dp = new long[60];
        for (int t : time) dp[t % 60]++;
        long ans = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) ans += ((dp[i] * (dp[i] - 1)) / 2);
            else ans += dp[i] * dp[60 - i];
        }
        return (int) ans;
    }
}
