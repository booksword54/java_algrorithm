import java.util.ArrayDeque;
import java.util.Deque;

public class LongestIncreasingSubsequence {
    // 最长递增子序列
    // 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
    // 动态规划
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n]; // 存储末尾元素的位置之前构成的单调递增最大长度
        dp[0] = 1;
        int max = 1;
        for (int end1 = 1; end1 < n; end1++) {
            dp[end1] = 1;
            for (int end0 = 0; end0 < end1; end0++) {
                if (nums[end1] > nums[end0]) {
                    dp[end1] = Math.max(dp[end1], dp[end0] + 1);
                }
            }
            max = Math.max(max, dp[end1]);
        }
        return max;
    }

    // 贪心 + 二分查找
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] range = new int[n]; // 递增区间
        int idx = 0;
        range[idx++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > range[idx - 1]) {
                range[idx++] = nums[i]; // 可以放到递增区间
                continue;
            }
            // 二分查找，找到第一个大于或等于的元素并替换它，满足严格递增
            int left = 0;
            int right = idx - 1;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (nums[i] <= range[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            range[right] = nums[i]; // 替换
        }
        return idx;
    }

}
