package multi_dimensional;

public class UniquePathsII {
    // 不同路径 II
    // 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
    // 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
    // 网格中的障碍物和空位置分别用 1 和 0 来表示。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 第一列的路径数
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 后面列行走不通了，结束
                break;
            }
            dp[i][0] = 1;
        }
        // 第一行的路径数
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                // 后面的行走不通了，结束
                break;
            }
            dp[0][j] = 1;
        }
        // 每行每列的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 可以走通
                if (obstacleGrid[i][j] == 0) {
                    // 上一行和上一列路径数之和
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // m行n列的路径数
        return dp[m - 1][n - 1];
    }
}
