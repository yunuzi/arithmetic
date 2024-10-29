/**
 * @param {number[]} customers
 * @param {number[]} grumpy
 * @param {number} minutes
 * @return {number}
 */
/**
 * 1052. 爱生气的书店老板
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 *
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 *
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 * @param customers
 * @param grumpy
 * @param minutes
 */
var maxSatisfied = function(customers, grumpy, minutes) {
    //1.老板不生气时顾客满意人数
    var sum = 0
    for(var i = 0;i < customers.length;i++){
        if(grumpy[i] === 0) {
            sum += customers[i];
        }
    }

    //2.使用minutes分钟不生气，可以满足多少顾客
    var sum2 = 0;
    var max = 0;
    var left = 0;
    for(var i = 0; i < customers.length;i++){
        if(i - left < minutes){
            sum2 += grumpy[i] === 1 ? customers[i] : 0;
        }else {
            left++;
            if(grumpy[left - 1] === 1){
                sum2 -= customers[left - 1];
            }
            if(grumpy[i] === 1){
                sum2 += customers[i];
            }
        }
        max = sum2 > max ? sum2 : max;
    }
    return sum + max;
};

maxSatisfied([4,10,10],[1,1,0],2)
