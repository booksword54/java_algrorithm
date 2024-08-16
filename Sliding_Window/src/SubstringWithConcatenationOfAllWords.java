import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    // 串联所有单词的子串
    // 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
    // s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
    // 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
    // "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
    // 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 所有单词的个数
        int num = words.length;
        // 每个单词的长度（是相同的）
        int wordLen = words[0].length();
        // 字符串长度
        int stringLen = s.length();
        for (int i = 0; i < stringLen; i++) {
            // 遍历的长度超过了整个字符串的长度，退出循环
            if (i + num * wordLen > stringLen) {
                break;
            }
            // differ表示窗口中的单词频次和words中的单词频次之差
            Map<String, Integer> differ = new HashMap<>();
            // 初始化窗口，窗口长度为 num * wordLen,依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < num; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 遍历words中的word，对窗口里每个单词计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 差值为0时，移除掉这个word
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            if (differ.isEmpty()) {
                // 初始的窗口匹配的单词数等于words中对应的单词数
                res.add(i);
            }
            // 开始滑动窗口
            for (int begin = i + wordLen; begin < stringLen - num * wordLen + 1; begin += wordLen) {
                String word = s.substring(begin + (num - 1) * wordLen, begin + num * wordLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
                word = s.substring(begin - wordLen, begin);
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 滑动后的窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) {
                    res.add(begin);
                }
            }
        }
        return res;
    }
}
