import java.util.List;

public class WordBreak {
    // 单词拆分
    // 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
    // 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int end = 1; end <= n; end++) { // 遍历字符串末尾位置，判断是否能被字典的单词拼接
            for (String word : wordDict) {
                int len = word.length();
                if (end >= len && dp[end - len] // 前面可以被拼接
                        && s.substring(end - len, end).equals(word)) { // 当前单词可以拼接上
                    dp[end] = true; // 直到末尾处，字符串可以被字典拼接
                    break;
                }
            }
        }
        return dp[n];
    }
}
