package com.sl.backtracking;


import java.util.*;

public class day_01 {


    /**
     * 39. 组合总和
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * @param candidates
     * @param target
     * @return
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtracking(candidates,target,0,0);
        return res;
    }


    private void backtracking(int[] candidates, int target, int startIndex,int sum) {
        if ( sum == target ) {
            res.add( new ArrayList<>( path ) );
            return;
        }
        for ( int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++ ) {
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if ( i > startIndex && candidates[i] == candidates[i - 1] ) {
                continue;
            }

            sum += candidates[i];
            path.add( candidates[i] );
            // i+1 代表当前组内元素只选取一次
            backtracking( candidates, target, i + 1,sum );

            int temp = path.getLast();
            sum -= temp;
            path.removeLast();
        }
    }


    /**
     * 40. 组合总和 II
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        backtracking2(candidates,target,0,0);
        return res;
    }

    private void backtracking2(int[] candidates, int target, int startIndex, int sum) {
        //判断终止条件
        if(sum > target) return;
        if(sum == target && !res.contains(new ArrayList<Integer>(path))){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = startIndex;i < candidates.length;i++){
            path.add(candidates[i]);
            sum += candidates[i];
            //进入循环
            backtracking(candidates,target,i + 1,sum);
            //进行回溯
            path.remove(path.size() -1);
            sum -= candidates[i];
        }

    }


}
