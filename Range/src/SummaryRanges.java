import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    // 汇总区间
    // 给定一个  无重复元素 的 有序 整数数组 nums 。
    // 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
    // 列表中的每个区间范围 [a,b] 应该按如下格式输出：
    // "a->b" ，如果 a != b
    // "a" ，如果 a == b
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 0;
        List<String> list = new ArrayList<>();
        while (right < nums.length) {
            while (right < nums.length - 1 && nums[right] + 1 == nums[right + 1]) {
                right++; // 连续区间的右边界
            }
            if (left == right) {
                list.add(Integer.toString(nums[left]));
            } else {
                list.add(nums[left] + "->" + nums[right]);
            }
            left = right + 1;
            right = left;
        }
        return list;
    }
}
