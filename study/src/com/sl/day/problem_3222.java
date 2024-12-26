/**
 * @author 孙铃
 * @date 2024/11/6 20:25
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3222
 * @Date：2024/11/6
 * @Filename：problem_3222
 */
public class problem_3222 {
    /**
     * 3222. 求出硬币游戏的赢家
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
     *
     * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿走价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
     *
     * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
     * @param x
     * @param y
     * @return
     */
    public String losingPlayer(int x, int y) {
        //1个75和4个10
        int count = 0;
        while(x >= 0 && y >= 0) {
            x -= 1;
            y -= 4;
            count++;
        }

        return count % 2 == 0 ? "Alice" : "Bob";
    }
}
