package multi_dimensional;

public class LongestPalindromicSubstring {
    // 最长回文子串
    // 给你一个字符串 s，找到 s 中最长的 回文子串
    // 动态规划
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int start = 0, end = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right)
                        && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        start = left;
                        end = right;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // 中心扩散
    public String longestPalindrome2(String s) {
        int length = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expand(s, i, i); // 奇数长度回文子串
            int len2 = expand(s, i, i + 1); // 偶数长度回文子串
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) >> 1); // len - 1 是因为取偶数位的时候 中间元素i是左边的那个，所以长度需要减去1，len是奇数的时候减一不影响start的位置
                end = i + (len >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    // 中心扩展，寻找回文的最大长度
    private int expand(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}