import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // 组合总和
    // 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    // candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    // 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int index = 0; // 起始位置
        backtrack(index, target, path, res, candidates);
        return res;
    }

    private void backtrack(int index, int target, List<Integer> path, List<List<Integer>> res, int[] candidates) {
        if (index == candidates.length) {
            return; // 此次遍历没有找到结果
        }
        if (target == 0) { // 找到了满足条件的结果
            res.add(new ArrayList<>(path));
            return;
        }
        backtrack(index + 1, target, path, res, candidates); // 跳过当前元素
        if (candidates[index] <= target) { // 选取当前元素
            path.add(candidates[index]);
            backtrack(index, target - candidates[index], path, res, candidates); // 起始值是index, 表示重复选取
            path.remove(path.size() - 1);
        }

    }
}
