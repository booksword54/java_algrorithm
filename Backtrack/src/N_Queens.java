import java.util.*;

public class N_Queens {
    // N 皇后
    // 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    // n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    // 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    // 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n]; // 皇后在每一行出现的位置
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>(); // 该列是否有皇后
        Set<Integer> diagonals1 = new HashSet<>(); // 左对角线是否有皇后
        Set<Integer> diagonals2 = new HashSet<>(); // 右对角线是否有皇后
        int row = 0;
        backtrack(row, n, columns, diagonals1, diagonals2, queens, res);
        return res;
    }

    private void backtrack(int row, int n, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2, int[] queens, List<List<String>> res) {
        if (row == n) {
            res.add(getBoard(queens, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) { // 该列有皇后
                continue;
            }
            int diagonal1 = row - i; // 遍历左对角线位置
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i; // 遍历右对角线位置
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            // 可以在 (row, i) 添加皇后
            queens[row] = i;
            columns.add(i); // 充当i列的皇后
            diagonals1.add(diagonal1); // 充当左对角线的皇后
            diagonals2.add(diagonal2); // 充当右对角线的皇后
            // 填充下一行的皇后位置
            backtrack(row + 1, n, columns, diagonals1, diagonals2, queens, res);
            // 回溯，遍历所有可能的结果
            diagonals2.remove(diagonal2);
            diagonals1.remove(diagonal1);
            columns.remove(i);
            queens[row] = -1;
        }
    }

    private List<String> getBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
