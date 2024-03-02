package com.sl.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：sl
 * @Package：com.sl.day
 * @Project：arithmetic
 * @name：problem_590
 * @Date：2024-2-19 10:56
 * @Filename：problem_590
 */
public class problem_590 {

    public List<Integer> resList = new ArrayList<Integer>();

    /**
     * 590. N 叉树的后序遍历
     * 简单
     * 相关标签
     * 相关企业
     * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
     *
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        checkFun(root);
        return resList;
    }

    private void checkFun(Node node) {
        if(node == null){
            return;
        }
      for(Node child : node.children){
          checkFun(child);
      }
      resList.add(node.val);
    }


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
    }

}


// Definition for a Node.

