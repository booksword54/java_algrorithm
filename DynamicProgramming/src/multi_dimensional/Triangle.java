package multi_dimensional;

import java.util.List;

public class Triangle {
    // 三角形最小路径和
    // 给定一个三角形 triangle ，找出自顶向下的最小路径和。
    // 每一步只能移动到下一行中相邻的结点上。
    // 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
    // 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[][] dp = new int[level][level];
        dp[0][0] = triangle.get(0).get(0);
        for (int l = 1; l < level; l++) {
            //  (l, 0)只能从(l-1,0)到达
            dp[l][0] = dp[l - 1][0] + triangle.get(l).get(0);
            for (int i = 1; i < l; i++) { // l行有l个元素
                // (l, i)可以从(l-1,i-1)或(l-1,i)到达，取路径和最小的那个
                dp[l][i] = Math.min(dp[l - 1][i - 1], dp[l - 1][i]) + triangle.get(l).get(i);
            }
            //  (l, l)只能从(l-1,l-1)到达
            dp[l][l] = dp[l - 1][l - 1] + triangle.get(l).get(l);
        }
        // 到达最后一层，获取到达最后一层的最小路径和
        int res = dp[level - 1][0];
        for (int i = 1; i < level; i++) {
            res = Math.min(res, dp[level - 1][i]);
        }
        return res;
    }

}
