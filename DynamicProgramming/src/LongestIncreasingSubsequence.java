import java.util.ArrayDeque;
import java.util.Deque;

public class LongestIncreasingSubsequence {
    // 最长递增子序列
    // 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // 递增区间
        int idx = 0;
        dp[idx++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[idx - 1]) {
                dp[idx++] = nums[i]; // 可以放到递增区间
                continue;
            }
            // 二分查找，找到第一个大于或等于的元素并替换它，满足严格递增
            int left = 0;
            int right = idx - 1;
            while (left < right) {
                int mid = ((right - left) >> 1) + left;
                if (nums[i] <= dp[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[right] = nums[i]; // 替换
        }
        return idx;
    }

}
