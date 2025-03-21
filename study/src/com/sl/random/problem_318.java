/**
 * @author 孙铃
 * @date 2024/10/23 11:23
 */
package com.sl.random;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_318
 * @Date：2024/10/23
 * @Filename：problem_318
 */
public class problem_318 {

    public int maxProduct(String[] words) {
        int n = words.length, idx = 0;
        int[] masks = new int[n];
        for (String w : words) {
            int t = 0;
            for (int i = 0; i < w.length(); i++) {
                int u = w.charAt(i) - 'a';
                //  有1则为1，计算出  字符串中在26位字母上有值的二进制数为多少
                t |= (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) {//为0说明不包含相同字母
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }


    @Test
    public void test() {
        System.out.println(1 | 1);
    }
}
