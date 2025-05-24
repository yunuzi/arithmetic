/**
 * @author 孙铃
 * @date 2025/5/16 17:04
 */
package com.sl.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_241
 * @Date：2025/5/16
 * @Filename：problem_241
 */
public class problem_241 {
    /**
     * 241. 为运算表达式设计优先级
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
     *
     * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10^4 。
     * @param expression
     * @return
     */

    char[] cs;
    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0, cs.length - 1);
    }

    //分治
    private List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for(int i =l;i<=r;i++){
            if(cs[i] >= '0' && cs[i] <= '9') continue;
            List<Integer> left = dfs(l, i - 1), right = dfs(i + 1, r);
            for(int a : left){
                for(int b : right){
                    if(cs[i] == '+') ans.add(a + b);
                    if(cs[i] == '-') ans.add(a - b);
                    if(cs[i] == '*') ans.add(a * b);
                }
            }
        }
        //计算边界情况
        if(ans.isEmpty()){
            int num = 0;
            for(int i = l;i<=r;i++){
                num = num * 10 + (cs[i] - '0');
            }
            ans.add(num);
        }
        return ans;
    }
}
