import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    // 电话号码的字母组合
    // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        int step = 0;
        backtrack(step, path, res, digits, map);
        return res;
    }

    private void backtrack(int step, StringBuilder path, List<String> res, String digits, Map<Character, String> map) {
        if (step == digits.length()) {
            res.add(path.toString());
            return;
        }
        char digit = digits.charAt(step);
        String letters = map.get(digit);
        int len = letters.length();
        for (int i = 0; i < len; i++) {
            path.append(letters.charAt(i));
            backtrack(step + 1, path, res, digits, map);
            path.deleteCharAt(path.length() - 1);
        }
    }


}
