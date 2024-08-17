package multi_dimensional;

public class MaximalSquare {
    // 最大正方形
    // 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') { // 位于边界，边长为1
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') { // 位于边界，边长为1
                dp[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int up = dp[i - 1][j]; // 上方全为1的正方形的边长
                    int left = dp[i][j - 1]; // 左边全为1的正方形的边长
                    int upLeft = dp[i - 1][j - 1]; // 左上方全为1的正方形的边长
                    dp[i][j] = Math.min(up, Math.min(left, upLeft)) + 1; // 最小的正方形边长向(i, j)方向拓展一格，拓展的内容保证全为1，因为另外两个边长较大的正方形覆盖到了
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
