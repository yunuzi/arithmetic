/**
 * @author 孙铃
 * @date 2025/3/14 13:28
 */
package com.sl.day;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3340
 * @Date：2025/3/14
 * @Filename：problem_3340
 */
public class problem_3340 {
    /**
     * 3340. 检查平衡字符串
     * 简单
     * 相关标签
     * 相关企业
     * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，
     * 则认为该数字字符串是一个 平衡字符串。
     *
     * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
     * @param num
     * @return
     */
    public boolean isBalanced(String num) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i <= 9;i++) {
            map.put(""+i,i);
        }

        Integer sum = 0;
        for(int i = 0;i < num.length();i++) {
            if(i % 2 == 0) {
                sum += map.get(num.substring(i,i+1));
            }else {
                sum -= map.get(num.substring(i,i+1));
            }
        }
        return sum == 0;
    }

    @Test
    public void test() {
        System.out.println(isBalanced("1210"));
    }
}
