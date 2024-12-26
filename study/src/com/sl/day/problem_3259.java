/**
 * @author 孙铃
 * @date 2024/11/1 11:07
 */
package com.sl.day;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_3259
 * @Date：2024/11/1
 * @Filename：problem_3259
 */
public class problem_3259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int len = energyDrinkA.length;
        long tempA = energyDrinkA[0];
        long tempB = energyDrinkB[0];

        for(int i = 1; i < len; i++) {
            long temp = tempA;
            //tempA + energyDrinkA[i] 不选B     tempB 选B
            tempA = Math.max(tempA + energyDrinkA[i],tempB);

            tempB = Math.max(tempB + energyDrinkB[i],temp);
        }

        return Math.max(tempA,tempB);
    }
}
