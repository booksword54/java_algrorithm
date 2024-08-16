import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    // 合并区间
    // 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
    public int[][] merge(int[][] intervals) {
        // 按照起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> ranges = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            if (ranges.size() == 0 || ranges.get(ranges.size() - 1)[1] < begin) {
                // 不冲突直接插入
                ranges.add(new int[]{begin, end});
            } else {
                // 产生冲突，合并区间
                ranges.get(ranges.size() - 1)[1] = Math.max(ranges.get(ranges.size() - 1)[1], end);
            }
        }
        return ranges.toArray(new int[ranges.size()][]);
    }
}
