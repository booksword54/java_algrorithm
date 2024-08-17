import java.util.HashSet;
import java.util.Set;

public class N_QueensII {
    // N 皇后 II
    // n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    // 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>(); // 该列是否有皇后
        Set<Integer> diagonals1 = new HashSet<>(); // 左对角线是否有皇后
        Set<Integer> diagonals2 = new HashSet<>(); // 右对角线是否有皇后
        int row = 0;
        return backtrack(row, n, columns, diagonals1, diagonals2);
    }

    public int backtrack(int row, int n, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1; // 所有行的皇后都已经填充，解决方案加一
        }
        int count = 0;
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
            columns.add(i); // 充当i列的皇后
            diagonals1.add(diagonal1); // 充当左对角线的皇后
            diagonals2.add(diagonal2); // 充当右对角线的皇后
            count += backtrack(row + 1, n, columns, diagonals1, diagonals2); // 改行以下可能结果数
            diagonals2.remove(diagonal2);
            diagonals1.remove(diagonal1);
            columns.remove(i);
        }
        return count; // 累计的解决方案数量
    }

}
