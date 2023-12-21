package com.sl.greedy;

/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：study
 * @name：problem_860
 * @Date：2023-12-19 18:02
 * @Filename：problem_860
 */
public class problem_860 {
    /**
     * 860. 柠檬水找零
     * 简单
     * 相关标签
     * 相关企业
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[2];
        if(bills[0] != 5){
            return false;
        }
        for(int i = 0;i < bills.length;i++){
            //5元直接加进来
            if(bills[i] == 5){
                money[0] += 5;
            }
            //10元直接找5元
            if(bills[i] == 10){
                money[0] -= 5;
                money[1] += 10;
                if(money[0] < 0) return false;
            }
            //20元分情况
            if(bills[i] == 20){
                if(money[1] > 0){//若有10元，则先找10元，再找5元
                    money[1] -= 10;
                    money[0] -= 5;
                }else{ //没有10元，找三张5元
                    money[0] -= 15;
                }

            }
            if(money[0] < 0) return false;
        }
        return true;

    }
}
