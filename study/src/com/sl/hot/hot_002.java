package com.sl.hot;

import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.*;

/**
 * @Author：sl
 * @Package：com.sl.hot
 * @Project：arithmetic
 * @name：hot_002
 * @Date：2024-3-8 16:35
 * @Filename：hot_002
 */
public class hot_002 {
    /**
     49. 字母异位词分组
     中等
     相关标签
     相关企业
     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

     字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     **/
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(strs[i]);
                map.put(key, list);
            } else {
                LinkedList<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            res.add(v);
        });

        return res;
    }
}
