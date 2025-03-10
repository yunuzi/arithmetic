/**
 * @author 孙铃
 * @date 2025/3/10 13:25
 */
package com.sl.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_981
 * @Date：2025/3/10
 * @Filename：problem_981
 */
public class problem_981 {
    /**
     * 981. 基于时间的键值存储
     * 中等
     * 相关标签
     * 相关企业
     * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
     *
     * 实现 TimeMap 类：
     *
     * TimeMap() 初始化数据结构对象
     * void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
     * String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。
     * 如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
     */
    class TimeMap {
        class Node {
            String k, v;
            int t;
            Node (String _k, String _v, int _t) {
                k = _k; v = _v; t = _t;
            }
        }

        Map<String, List<Node>> map = new HashMap<>();
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<Node> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Node(key, value, timestamp));
            map.put(key, list);
        }

        public String get(String key, int timestamp) {
            //找到这个key
            List<Node> list = map.getOrDefault(key, new ArrayList<>());
            if(list.isEmpty()) {
                return "";
            }
            int n = list.size();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid).t <= timestamp) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return list.get(r).t <= timestamp ? list.get(r).v : "";
        }
    }
}
