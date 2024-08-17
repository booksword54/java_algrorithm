import com.sun.org.apache.regexp.internal.RE;

public class WordSearch {
    // 单词搜索
    // 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int idx = 0; // 第几个字符
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 尝试从每一个位置起步，寻找路径
                if (dfs(idx, i, j, m, n, board, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int idx, int i, int j, int m, int n, char[][] board, String word, boolean[][] visited) {
        if (board[i][j] != word.charAt(idx)) {
            return false; // 遍历的位置错误,继续寻路
        }
        if (idx == word.length() - 1) {
            return true; // 到达终点
        }
        visited[i][j] = true; // 走当前位置，接下来不能再访问
        for (int[] dir : dirs) { // 所有方向寻路
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m
                    && nj >= 0 && nj < n // 位置合规
                    && !visited[ni][nj] // 没有访问过
                    && dfs(idx + 1, ni, nj, m, n, board, word, visited)) { // 可以到终点
                return true;
            }
        }
        visited[i][j] = false; // 现在不能走这个地方，撤回，之后可以重新访问
        return false;
    }
}
