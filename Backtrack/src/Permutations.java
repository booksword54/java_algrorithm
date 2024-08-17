import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    // 全排列
    // 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        int begin = 0;
        backtrack(begin, path, res);
        return res;
    }

    private void backtrack(int begin, List<Integer> path, List<List<Integer>> res) {
        if (begin == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < path.size(); i++) {
            Collections.swap(path, begin, i); // 当前位置和每一个位置交换
            backtrack(begin + 1, path, res); // 遍历下一个位置，同样执行和每一个位置交换
            Collections.swap(path, begin, i); // 回溯，遍历所有可能的结果
        }
    }
}
