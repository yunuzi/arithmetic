/**
 * @author 孙铃
 * @date 2025/3/19 10:38
 */
package com.sl.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2610
 * @Date：2025/3/19
 * @Filename：problem_2610
 */
public class problem_2610 {

    /**
     * 2610. 转换二维数组
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
     *
     * 二维数组应该 只 包含数组 nums 中的元素。
     * 二维数组中的每一行都包含 不同 的整数。
     * 二维数组的行数应尽可能 少 。
     * 返回结果数组。如果存在多种答案，则返回其中任何一种。
     *
     * 请注意，二维数组的每一行上可以存在不同数量的元素。
     * @param nums
     * @return
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < len;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
                if(res.size() >= map.getOrDefault(nums[i],0)) {//存在
                    res.get(map.getOrDefault(nums[i],0) -1).add(nums[i]);
                }else {
                    res.add(new ArrayList<>());
                    res.get(map.getOrDefault(nums[i],0) -1).add(nums[i]);
                }
            }else {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
                //如果不存在第一行
                if(res.isEmpty()) {
                    res.add(new ArrayList<>());
                    res.get(0).add(nums[i]);
                }else {
                    res.get(0).add(nums[i]);
                }
            }
        }
        return res;
    }
}
