/**
 * @author 孙铃
 * @date 2024/10/24 17:23
 */
package com.sl.random;

import org.junit.Test;

/**
 * @Author：孙铃
 * @Package：com.sl.random
 * @Project：arithmetic
 * @name：problem_3175
 * @Date：2024/10/24
 * @Filename：problem_3175
 */
public class problem_3175 {
    public int findWinningPlayer(int[] skills, int k) {
        //遍历一轮就可以看出来,当k >= skills.length - 1的时候，最大的数字就是winner
        int res = -1;
        res = skills[0] - skills[1] > 0 ?  0 : 1;
        int temp = skills[0] - skills[1] > 0 ? skills[0] : skills[1];
        int winCount = 1;
        if(winCount >= k) {
            return res;
        }
        for(int i = 2; i < skills.length; i++){
            res = temp - skills[i] > 0 ? res : i;
            winCount = temp - skills[i] > 0 ? (winCount + 1) : 1;
            temp = Math.max(temp, skills[i]);
            if(winCount >= k) {
                return res;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
    }
}
