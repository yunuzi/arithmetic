package com.sl.greedy;



/**
 * @Author：sl
 * @Package：com.sl.greedy
 * @Project：arithmetic
 * @name：problem_968
 * @Date：2023-12-22 9:44
 * @Filename：problem_968
 */
public class problem_968 {



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
      }


    /**
     * 968. 监控二叉树
     * 困难
     * 相关标签
     * 相关企业
     * 给定一个二叉树，我们在树的节点上安装摄像头。
     *
     * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
     *
     * 计算监控树的所有节点所需的最小摄像头数量。
     * @param root
     * @return
     */
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0){//若头节点没有被覆盖，则需要放置一个摄像头
            res++;
        }
        return res;
    }

    //定义0：未覆盖  1：有摄像头  2：被覆盖
    //进行后续遍历，左 右 中
    public int traversal(TreeNode cur){
        //当前节点为null,则返回2
        if(cur == null){
            return 2;
        }

        int left = traversal(cur.left);
        int right = traversal(cur.right);

        //当左右节点都被覆盖，则父节点为 未覆盖状态时摄像头可以放最少
        if(left == 2 && right == 2) return 0;

        //当左右节点至少有一个 节点为未覆盖状态，则父节点必须放摄像头
        if(left == 0 || right == 0){
            res++;
            return 1;
        }

        //当左右节点至少有一个放摄像头,则父节点就被覆盖
        if(left == 1 || right == 1) return 2;

        return -1;

    }
}
