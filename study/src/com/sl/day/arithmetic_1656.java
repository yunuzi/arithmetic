/**
 * @author 孙铃
 * @date 2025/2/24 9:59
 */
package com.sl.day;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author：孙铃
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：arithmetic_1656
 * @Date：2025/2/24
 * @Filename：arithmetic_1656
 */
public class arithmetic_1656 {


    /**
     * 1656. 设计有序流
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
     *
     * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
     *
     * 实现 OrderedStream 类：
     *
     * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
     * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
     * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
     * 否则，返回一个空列表。
     */
    class OrderedStream {
//
//        public  List<String> stream = new ArrayList<>();
//
//        public int ptr = 1;
//
//        public OrderedStream(int n) {
//            for(int i = 0;i < n;i++) {
//                stream.add("");
//            }
//        }
//
//        public List<String> insert(int idKey, String value) {
//            List<String> res = new ArrayList<>();
//            stream.set(idKey - 1,value);
//            //判斷是否有ptr對應的值
//            if(ptr > stream.size()) {
//                return res;
//            }
//            if(!Objects.equals(stream.get(ptr - 1), "")){
//                while (!Objects.equals(stream.get(ptr - 1), "")){
//                    res.add(stream.get(ptr - 1));
//                    ptr++;
//                    if(ptr > stream.size()) {
//                        return res;
//                    }
//                }
//            }
//            return res;
//        }

        String[] strs;
        int size;
        int ptr ;
        public OrderedStream(int n) {
            strs = new String[n+1];
            size = 0;
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            List<String> ans = new ArrayList<>();
            strs[idKey] = value;
            size++;
            while (ptr<strs.length&&strs[ptr]!=null){
                ans.add(strs[ptr++]);
            }
            return ans;
        }

    }

    @Test
    public void test() {
        OrderedStream os = new OrderedStream(5);
        List<String> res = os.insert(3, "ccccc");
        System.out.println(res);
        res = os.insert(1, "aaaaa");
        System.out.println(res);
        res = os.insert(2, "bbbbb");
        System.out.println(res);
        res = os.insert(5, "eeeee");
        System.out.println(res);
        res = os.insert(4, "ddddd");
        System.out.println(res);
    }
}
