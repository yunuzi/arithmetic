package com.sl.Study.BasicProgramming;

import org.junit.Test;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_682
 * @Date：2024-7-25 14:51
 * @Filename：problem_682
 */
public class problem_682 {
    /**
     * 682. 棒球比赛
     * 简单
     * 相关标签
     * 相关企业
     * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
     *
     * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
     *
     * 整数 x - 表示本回合新获得分数 x
     * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
     * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * 请你返回记录中所有得分的总和。
     *
     *
     * @param operations
     * @return
     */
    public int calPoints(String[] operations) {
        int sum = 0;
        int [] arr = new int[operations.length];
        int start = 0;
        for(int i = 0;i < operations.length;i++){
            //数字
            if(!operations[i].equals("+") && !operations[i].equals("D") && !operations[i].equals("C")){
                arr[start] = Integer.parseInt(operations[i]);
                sum += arr[start];
            }
            if(operations[i].equals("+")){
                arr[start] = arr[start-1] + arr[start-2];
                sum += arr[start];
            }
            if(operations[i].equals("D")){
                arr[start] = 2 * arr[start - 1];
                sum += arr[start];
            }
            if(operations[i].equals("C")){
                sum -= arr[start-1];
                arr[start-1] = 0;
                start--;
                start--;
            }
            start++;
        }
        return sum;
    }

    @Test
    public void test(){
        calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
    }
}
