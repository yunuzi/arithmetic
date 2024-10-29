package com.sl.day;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2766
 * @Date：2024-7-24 10:06
 * @Filename：problem_2766
 */
public class problem_2766 {
    /**
     * 2766. 重新放置石块
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 moveTo 。
     *
     * 在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 moveTo[i] 。
     *
     * 完成这些操作后，请你按升序返回所有 有 石块的位置。
     * @param nums
     * @param moveFrom
     * @param moveTo
     * @return
     */
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }int len = moveFrom.length;
        for(int i = 0;i< len;i++){
            if(moveFrom[i] == moveTo[i]){
                continue;
            }
            if(map.containsKey(moveFrom[i])){
                map.put(moveTo[i],map.getOrDefault(moveTo[i],0)+map.get(moveFrom[i]));
                map.remove(moveFrom[i]);
            }
        }
        return map.keySet().stream().sorted().collect(Collectors.toList());
    }
}
