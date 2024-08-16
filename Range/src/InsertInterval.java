import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    // 插入区间
    // 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
    // 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
    // 返回插入之后的 intervals。
    // 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ranges = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // 左侧区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            ranges.add(intervals[i]);
            i++;
        }
        // 区间重叠 开始节点 一定小于等于newInterval的结束值 结束结点一定大于等于newInterval的开始值
        while (i < n && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ranges.add(newInterval);
        // 右侧区间
        while (i < n && intervals[i][0] > newInterval[1]) {
            ranges.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[ranges.size()][];
        for (int j = 0; j < ranges.size(); j++) {
            ans[j] = ranges.get(j);
        }
        return ans;
    }
}
