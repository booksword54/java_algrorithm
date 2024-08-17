import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // 括号生成
    // 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int open = 0, close = 0;  // 左右括号数量
        backtrack(open, close, n, path, res);
        return res;
    }

    private void backtrack(int open, int close, int n, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        // 添加左括号, 前提是左括号数量不能多于n
        if (open < n) {
            path.append("(");
            backtrack(open + 1, close, n, path, res); // 在已添加左括号的基础上延伸
            // 回溯，遍历所有可能性
            path.deleteCharAt(path.length() - 1);
        }
        // 添加右括号, 前提是右括号数量不能多于左括号
        if (close < open) {
            path.append(")");
            backtrack(open, close + 1, n, path, res); // 在已添加右括号的基础上延伸
            // 回溯，遍历所有可能性
            path.deleteCharAt(path.length() - 1);
        }
    }
}
