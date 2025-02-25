/**
 * @author 孙铃
 * @date 2025/2/25 10:08
 */
package com.sl.day;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_0808mianshiti
 * @Date：2025/2/25
 * @Filename：problem_0808mianshiti
 */
public class problem_0808mianshiti {

    /**
     * q全排列去重
     * 面试题 08.08. 有重复字符串的排列组合
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合
     * @param S
     * @return
     */
    LinkedList<String> list = new LinkedList<>();
    public String[] permutation(String S) {
        dfs(S.toCharArray(), 0);
        return list.toArray(new String[0]);
    }
    public void dfs(char[] c, int k){
        if(k == c.length){
            list.add(new String(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = k; i < c.length; i++){
            if(!set.contains(c[i])){
                set.add(c[i]);
                swap(c, i, k);
                dfs(c, k+1);
                swap(c, i, k);
            }
        }
    }
    public void swap(char[] c, int x, int y){
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
}
