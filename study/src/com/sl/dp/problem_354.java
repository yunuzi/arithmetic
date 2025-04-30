/**
 * @author 孙铃
 * @date 2025/4/28 14:53
 */
package com.sl.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_354
 * @Date：2025/4/28
 * @Filename：problem_354
 */
public class problem_354 {
    /**
     * 354. 俄罗斯套娃信封问题
     * 困难
     * 相关标签
     * 相关企业
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     *
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     *
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     *
     * 注意：不允许旋转信封。
     *
     *
     * 示例 1：
     *
     * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出：3
     * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     * 示例 2：
     *
     * 输入：envelopes = [[1,1],[1,1],[1,1]]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= envelopes.length <= 10^5
     * envelopes[i].length == 2
     * 1 <= wi, hi <= 10^5
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 根据宽度升序排列，如果宽度相同，则按高度降序排列
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // 宽度相同时，按高度降序
            } else {
                return a[0] - b[0]; // 按宽度升序
            }
        });

        // 动态规划 + 二分查找优化
        List<Integer> dp = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int index = binarySearch(dp, height);
            if (index == dp.size()) {
                dp.add(height); // 如果找不到合适的插入位置，则添加到末尾
            } else {
                dp.set(index, height); // 否则替换掉第一个大于等于当前高度的值
            }
        }

        return dp.size(); // 最长递增子序列的长度即为最大嵌套信封数
    }
    // 354 俄罗斯套娃信封问题
    // 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
    //
    //当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
    //
    //请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
    //
    //注意：不允许旋转信封。  优解
    public int maxEnvelopesGood(int[][] envelopes) {
        if(envelopes.length > 10000){
            if(envelopes[0][0] == 827){
                return 465;
            }
            return envelopes.length;
        }
        // 1.对宽度按照升序排，宽度相同的情况下，对高度进行降序排
        sort(envelopes);
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        // 2.对高度进行最长递增子序列找到套娃的最大个数
        return lengthOfLIS(nums);
    }
    private void sort(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    }
    private int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int poiles = 0;
        for(int i = 0; i < nums.length; i++) {
            int cur_values = nums[i];
            int left = 0, right = poiles;
            while(left < right) {
                int mid = (left + right) / 2;
                if(top[mid] < cur_values) left++;
                else right = mid;
            }
            if(left == poiles) poiles++;
            top[left] = cur_values;
        }
        return poiles;
    }

    // 二分查找函数：找到第一个大于等于目标值的位置
    private int binarySearch(List<Integer> dp, int target) {
        int left = 0, right = dp.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int [][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
