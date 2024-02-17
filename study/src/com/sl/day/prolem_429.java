package com.sl.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：prolem_429
 * @Date：2024-2-17 16:27
 * @Filename：prolem_429
 */
public class prolem_429 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };



    /**
     * 429. N 叉树的层序遍历
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     *
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * @param root
     * @return
     */


    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(Node root) {
        checkFun(root);
        return resList;
    }

    private void checkFun(Node node) {
        if(node == null){
            return;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.offer(node);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                Node node1 = que.poll();
                list.add(node1.val);
                if(node1.children != null && node1.children.size() > 0){
                    for(Node node2 : node1.children){
                        que.offer(node2);
                    }
                }
            }
            resList.add(list);
        }



    }
}



