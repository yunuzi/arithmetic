package com.sl.Study.BasicProgramming;

/**
 * @Author：sl
 * @Package：com.sl.Study.BasicProgramming
 * @Project：arithmetic
 * @name：problem_1041
 * @Date：2024-7-26 10:15
 * @Filename：problem_1041
 */
public class problem_1041 {
    /**
     *1041. 困于环中的机器人
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
     *
     * 北方向 是y轴的正方向。
     * 南方向 是y轴的负方向。
     * 东方向 是x轴的正方向。
     * 西方向 是x轴的负方向。
     * 机器人可以接受下列三条指令之一：
     *
     * "G"：直走 1 个单位
     * "L"：左转 90 度
     * "R"：右转 90 度
     * 机器人按顺序执行指令 instructions，并一直重复它们。
     *
     * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;//规定 0 上  1 右  2 下  3 左
        char[] charArray = instructions.toCharArray();
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < charArray.length;j++){
                if('G' == charArray[j]){
                    if(direction == 0){
                        y++;
                    }
                    if(direction == 1){
                        x++;
                    }
                    if(direction == 2){
                        y--;
                    }
                    if(direction == 3){
                        x--;
                    }
                }
                if('L' == charArray[j]){
                    direction++;
                    if(direction == 4){
                        direction = 0;
                    }
                }
                if('R' == charArray[j]){
                    direction--;
                    if(direction == -1){
                        direction = 3;
                    }
                }
            }
        }
        return (x == 0 && y == 0);
    }
}
