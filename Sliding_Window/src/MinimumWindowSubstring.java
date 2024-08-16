import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // 最小覆盖子串
    // 给你一个字符串 s 、一个字符串 t 。
    // 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) { // 所需要的各个字母个数
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0, minLen = Integer.MAX_VALUE; // 起始位置和长度
        int left = 0, right = 0; // 窗口左右边界
        int valid = 0; // 窗口内有效字母个数
        while (right < s.length()) {
            char add = s.charAt(right); // 窗口添加字母
            if (need.containsKey(add)) {
                window.put(add, window.getOrDefault(add, 0) + 1);
                if (window.get(add).equals(need.get(add))) {
                    valid++; // 有效字母加一
                }
            }
            while (valid == need.size()) { // 获取最小长度，移动左边界
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                char delete = s.charAt(left); // 删除做边界元素
                if (window.containsKey(delete)) {
                    if (window.get(delete).equals(need.get(delete))) {
                        valid--;  // 是有效的字母，减一个
                    }
                    window.put(delete, window.get(delete) - 1);
                }
                left++; // 移动左边界
            }
            right++; // 移动右边界，添加下一个字母
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
