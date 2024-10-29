package com.sl.day;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_739
 * @Date：2024-8-21 13:19
 * @Filename：problem_739
 */
public class problem_739 {
    /**
     * 739. 每日温度
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];

        //单调栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i = 1;i < n;i++){
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
