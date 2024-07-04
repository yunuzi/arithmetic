package com.sl.arithmeticTrain;

/**
 * @Author：sl
 * @Package：com.sl.arithmeticTrain
 * @Project：arithmetic
 * @name：problem_2748
 * @Date：2024-7-4 16:58
 * @Filename：problem_2748
 */
public class problem_2748 {
    /**
     * 2748. 美丽下标对的数目
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，
     * 则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
     *
     * 返回 nums 中 美丽下标对 的总数目。
     *
     * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，
     * 则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
     * @param nums
     * @return
     */
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++) {
                if (cnt[y] > 0 && gcd(y, x % 10) == 1) {
                    ans += cnt[y];
                }
            }
            while (x >= 10) {
                x /= 10;
            }
            cnt[x]++; // 统计最高位的出现次数
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
