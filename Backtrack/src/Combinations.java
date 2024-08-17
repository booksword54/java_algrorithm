import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // 组合
    // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    // 你可以按 任何顺序 返回答案。
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int start = 1;
        backtrack(start, path, res, n, k);
        return res;
    }

    private void backtrack(int start, List<Integer> path, List<List<Integer>> res, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, path, res, n, k); // 不可以重复选择 i + 1
            path.remove(path.size() - 1);
        }
    }

}
