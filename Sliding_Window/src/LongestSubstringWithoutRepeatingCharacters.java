import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while (right < n) {
            Character rch = s.charAt(right);
            right++;
            while (window.contains(rch)) {
                Character lch = s.charAt(left);
                left++;
                window.remove(lch);
            }
            window.add(rch);
            max = Math.max(max, right - left);
        }
        return max;
    }
}
