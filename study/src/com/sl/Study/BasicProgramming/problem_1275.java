package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1275
 * @Date：2024-7-25 15:18
 * @Filename：problem_1275
 */
public class problem_1275 {
    /**
     * 1275. 找出井字棋的获胜者
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * A 和 B 在一个 3 x 3 的网格上玩井字棋。
     *
     * 井字棋游戏的规则如下：
     *
     * 玩家轮流将棋子放在空方格 (" ") 上。
     * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
     * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
     * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
     * 如果所有方块都放满棋子（不为空），游戏也会结束。
     * 游戏结束后，棋子无法再进行任何移动。
     * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
     *
     * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
     *
     * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
     * @param moves
     * @return
     */
        public String tictactoe(int[][] moves) {
            int m = moves.length;
            // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
            // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
            int[] count = new int[8];
            // 思路第2步已解释为何只需考虑最后一个落棋的人
            // 倒序统计此人走棋情况
            for(int i = m - 1; i >= 0; i -= 2) {
                // 此棋对行的影响
                count[moves[i][0]]++;
                // 此棋对列的影响
                count[moves[i][1] + 3]++;
                // 此棋对正对角线的影响
                if(moves[i][0] == moves[i][1])
                    count[6]++;
                // 此棋对副对角线的影响 (此处为3x3的情况，其余大小的棋盘可以类推)
                if(moves[i][0] + moves[i][1] == 2)
                    count[7]++;
                // 满3个棋子则胜利
                if(count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 ||
                        count[6] == 3 || count[7] == 3)
                    // A先B后 则总长度为偶时 最后为B 反之为A
                    return m % 2 == 0 ? "B" : "A";
            }
            // 未胜时，棋盘未下满则继续
            if(moves.length < 9)
                return "Pending";
            // 未胜时，棋盘下满则平局结束
            return "Draw";
        }
}
