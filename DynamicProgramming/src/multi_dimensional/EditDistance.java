package multi_dimensional;

public class EditDistance {
    // 编辑距离
    // 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
    // 你可以对一个单词进行如下三种操作：
    // - 插入一个字符
    // - 删除一个字符
    // - 替换一个字符
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; // 表示从m个字符的word1 到n个字符的word2所需的操作数
        // 删除word1的所有字符，从 i 到 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 添加word2的所有字符，从 0 到 j
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int add = dp[i][j - 1] + 1; // 添加字符 word2[j]
                int delete = dp[i - 1][j] + 1; // 删除字符 word1[i]
                int replace; // 替换字符
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    replace = dp[i - 1][j - 1];
                } else {
                    replace = dp[i - 1][j - 1] + 1; // 替换 word1[i] 为 word2[j]
                }
                dp[i][j] = Math.min(add, Math.min(delete, replace));
            }
        }
        return dp[m][n];
    }
}
