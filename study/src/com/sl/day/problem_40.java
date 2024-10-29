package com.sl.day;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_40
 * @Date：2024-8-1 10:32
 * @Filename：problem_40
 */
public class problem_40 {
    /**
     * LCP 40. 心算挑战
     * 简单
     * 相关标签
     * 相关企业
     * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，
     * 则选手成绩「有效」且得分为 cnt 张卡牌数字总和。 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。
     * 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
     * @param cards
     * @param cnt
     * @return
     */
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int res = 0;
        int odd = 0;
        int even = 0;
        int len = cards.length;
        int [] oddArr = new int[len];
        int [] evenArr = new int[len];
        for(int i = 0;i < len;i++){
            if(cards[i] % 2 == 0){
                evenArr[even] = cards[i];
                even++;
            }else {
                oddArr[odd] = cards[i];
                odd++;
            }
        }
        int useOdd = 0;
        int useEven = 0;
        for(int i = len - 1;i >= 0;i--){
            if(odd >0 || even > 0){
                res += cards[i];
                cnt--;
                if(cards[i] % 2 == 0){
                    even--;
                    useEven++;
                }else {
                    odd--;
                    useOdd++;
                }
            }
            if(cnt == 0){
                if(useOdd % 2 == 0){
                    return res;
                }
                //奇数用完了，我们去掉最后一个最小奇数，加上最大的一个一个偶数
                if(even > 0 && odd == 0){
                    res -= oddArr[odd];
                    res += evenArr[--even];
                    return res;
                }
                //偶数用完了，我们则去掉最小的那个偶数，添加一个现有的最大的奇数,如果本来就没有偶数，则不进入
                if(even == 0 && odd > 0 && evenArr[even] > 0){
                    res -= evenArr[even];
                    res += oddArr[--odd];
                    return res;
                }
                //奇数和偶数都存在，我们需要判断一下是去掉最后的偶数加一个奇数大，还是去掉最后的奇数，加一个偶数大
                if(even > 0 && odd > 0 && useEven > 0 && useOdd > 0){
                    res =Math.max(res -evenArr[even] + oddArr[odd -1],res - oddArr[odd] + evenArr[even -1]);
                    return res;
                }
                //如果没有我们没用到偶数,则我们只能去掉最后一个奇数，加上最大的偶数
                if(useEven == 0 && even > 0 && odd > 0){
                    res -= oddArr[odd];
                    res += evenArr[--even];
                    return res;
                }
                return 0;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] cards = {7,4,1};
        int cnt = 1;
        System.out.println(maxmiumScore(cards, cnt));
    }
}
