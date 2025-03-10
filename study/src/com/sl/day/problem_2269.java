/**
 * @author 孙铃
 * @date 2025/3/10 13:10
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_2269
 * @Date：2025/3/10
 * @Filename：problem_2269
 */
public class problem_2269 {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String str = String.valueOf(num);
        int n = str.length();
        for(int i = 0;i <= n - k;i++) {
            String sub = str.substring(i,i + k);
            res += isTrue(sub,num,k);
        }
        return res;
    }

    private int isTrue(String sub, int num, int k) {
        //去除sub前面的0
        while(k >0 && sub.charAt(0) == '0') {
            sub = sub.substring(1,k--);
        }
        if(k == 0) {
            return 0;
        }
        int subNum = Integer.parseInt(sub);
        if(num % subNum == 0){
            return 1;
        }
        return 0;
    }
}
