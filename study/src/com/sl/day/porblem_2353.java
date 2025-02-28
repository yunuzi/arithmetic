/**
 * @author 孙铃
 * @date 2025/2/28 9:15
 */
package com.sl.day;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：poblem_2353
 * @Date：2025/2/28
 * @Filename：poblem_2353
 */
public class porblem_2353 {
    /**
     * 2353. 设计食物评分系统
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 设计一个支持下述操作的食物评分系统：
     *
     * 修改 系统中列出的某种食物的评分。
     * 返回系统中某一类烹饪方式下评分最高的食物。
     * 实现 FoodRatings 类：
     *
     * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
     * foods[i] 是第 i 种食物的名字。
     * cuisines[i] 是第 i 种食物的烹饪方式。
     * ratings[i] 是第 i 种食物的最初评分。
     * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
     * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
     * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
     */
    class FoodRatings {
        private final Map<String, Pair<Integer, String>> foodMap = new HashMap<>();
        private final Map<String, TreeSet<Pair<Integer, String>>> cuisineMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodMap.put(food, new Pair<>(rating, cuisine));
                cuisineMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) ->
                        !Objects.equals(a.getKey(), b.getKey()) ? b.getKey() - a.getKey() : a.getValue().compareTo(b.getValue())
                )).add(new Pair<>(rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            Pair<Integer, String> p = foodMap.get(food);
            TreeSet<Pair<Integer, String>> st = cuisineMap.get(p.getValue());
            st.remove(new Pair<>(p.getKey(), food)); // 移除旧数据
            st.add(new Pair<>(newRating, food)); // 添加新数据
            foodMap.put(food, new Pair<>(newRating, p.getValue()));
        }

        public String highestRated(String cuisine) {
            return cuisineMap.get(cuisine).first().getValue();
        }
    }
}
