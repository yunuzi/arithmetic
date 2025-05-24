/**
 * @author 孙铃
 * @date 2025/5/10 13:35
 */
package com.sl.dp;

/**
 * @Author：孙铃
 * @Package：com.sl.dp
 * @Project：arithmetic
 * @name：problem_10
 * @Date：2025/5/10
 * @Filename：problem_10
 */
public class problem_10 {
    /**
     * 10. 正则表达式匹配
     * 困难
     * 相关标签
     * 相关企业
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
     * @param s
     * @param p
     * @return
     *
     * 提示：
     *
     * 1 <= s.length <= 20
     * 1 <= p.length <= 20
     * s 只包含从 a-z 的小写字母。
     * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     */
    public boolean isMatch(String s, String p) {
         /*
        dp五部曲:
        设主串s的长度为m,设模式串p的长度为n;其中s只有小写字母,p有字母/./*
        1.状态定义:dp[i][j]为考虑s[0,i-1]与p[0,j-1]是否能匹配上,能匹配上就为true
        2.状态转移:若要求dp[i][j]就必须考虑到s[i-1]与p[j-1]
            2.1 当p[j-1]不是'*'时
                2.1.1 若s[i-1]==p[j-1]时,即p[j-1]为'a'-'z'且与s[i-1]相等,看dp[i-1][j-1]
                2.1.2 p[j-1] == '.'时,直接将'.'变成s[i-1],看dp[i-1][j-1]
                注意:这里的'.'是匹配一个字符,而不是一连串,如"a.b"->"axb"
            2.2 当p[j-1]是'*'时,主要看p[j-2]做判断
                2.2.1 p[j-2]为'a'-'z'并且p[j-2]==s[i-1],那么此时s继续往前看,p暂时不动
                    即:看dp[i-1][j]
                2.2.2 p[j-2]为'.',那么".*"可以变为"....."可以匹配s[i-1]前面的任何字符(万能串)
                    因此,直接看dp[i-1][j](或者直接返回true)
                2.2.3 剩下的就是p[j-2]为'a'-'z'且p[j-2]!=s[i-1],那么此时p的"x*"作废,看dp[i][j-2]
            这里:2.1.1与2.2.2可以看成一种情形:即s与p均前移一位
                2.2.1与2.2.2可以看成一种情形:即p不动s前移一位
        3.初始化:
            3.1 空的s
                3.1.1 空的p,空的s可以匹配空的p,因此dp[0][0]=true
                3.1.2 非空的p,空的s可能可以匹配非空的p,例如"a*",因此需要经过转移计算
            3.2 空的p
                3.2.1 空的s,同3.1.1
                3.2.2 非空的s,空的p不可能匹配非空的s,因此dp[i][0]=false,i∈[1,m]
            3.3 非空的s与非空的p:需要经过转移计算
            其中:3.1.1与3.2.2可以合并为dp[i][0]=i==0
        4.遍历顺序:显然是正序遍历
        5.返回形式:返回dp[m][n]就是考虑s[0,m-1]与p[0,n-1]是否能匹配上
        */
//        int m = s.length(), n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        // 初始化dp[i][0]
//        // for(int i = 0; i <= m; i++) {
//        //     dp[i][0] = i == 0;
//        // }
//        dp[0][0] = true;
//        // i从0开始
//        for(int i = 0; i <= m; i++) {
//            // 注意j从1开始
//            for(int j = 1; j <= n; j++) {
//                if(p.charAt(j - 1) != '*') {
//                    // 1.当p[j-1]不是'*'时(注意j已经从1开始了)
//                    // 这里要注意运算优先级问题(加括号)
//                    if(i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
//                        // s与p均前移一位
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                } else {
//                    // 2.当p[j-1]是'*'时,主要看p[j-2]做判断
//                    if(j >= 2 && i >= 1 &&
//                            (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
//                        // 看"x*":p不动s前移一位
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                    // 不看"x*":
//                    // 剩下的为p[j-2]为'a'-'z'且p[j-2]!=s[i-1],那么此时p的"x*"作废,看dp[i][j-2]
//                    if(j >= 2) {
//                        dp[i][j] |= dp[i][j - 2];
//                    }
//                    // 这里的|=表示只要满足了其中一个条件就可以使得dp[i][j]==true
//                    // 通俗一点的解释就是:当p[j-1]=='*'时,
//                    // 若p[j-2]==s[i-1]||p[j-2]=='.',则dp[i][j]可以继承dp[i-1][j]:转移路径1
//                    // 若p[j-2]!=s[i-1],则dp[i][j]可以继承dp[i][j-2]:转移路径2
//                    // 满足任意一条转移路径就可以使得dp[i][j]=true
//                }
//            }
//        }
//        // 所求即为考虑s[0,m-1]与p[0,n-1]是否能匹配上
//        return dp[m][n];



        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];

    }


    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
