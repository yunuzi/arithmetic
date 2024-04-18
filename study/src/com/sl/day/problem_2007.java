/**
 * @author 孙铃
 * @date 2024/4/18 19:14
 */
package com.sl.day;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 铃
 * @date 2024/4/18 19:14
 */
public class problem_2007 {
    /**
     * 2007. 从双倍数组中还原原数组
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
     *
     * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
     * @param changed
     * @return
     */
    public int[] findOriginalArray(int[] changed) {
        int[] res = new int[changed.length / 2];
        Arrays.sort(changed);
        int index = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < changed.length;i++){
            if(!map.containsKey(changed[i])){//x不是双倍元素
                if(index == res.length){
                    return new int[0];
                }
                map.put(2 * changed[i],map.getOrDefault(2 * changed[i],0) +1);
                res[index++] = changed[i];
            }else{//x是双倍元素
                int num = map.get(changed[i]);
                if(num == 1){
                    map.remove(changed[i]);
                }else{
                    map.put(changed[i],num - 1);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] changed = {1,3,4,2,6,8};
        int[] res = findOriginalArray(changed);
        System.out.println(Arrays.toString(res));
    }
}
