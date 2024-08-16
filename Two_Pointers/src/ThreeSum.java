import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    // 注意：答案中不可以包含重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举第一个数
        for (int first = 0; first < n; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 第三个数指针指向最右端
            int third = n - 1;
            int target = -nums[first]; // 第二和第三个数的目标和
            // 枚举第二个数
            for (int second = first + 1; second < third; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 第二个数 的指针在 第三个数 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[first]);
                    pair.add(nums[second]);
                    pair.add(nums[third]);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }
}
