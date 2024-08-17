public class FindFirstAndLastPositionOfElementInSortedArray {
    // 在排序数组中查找元素的第一个和最后一个位置
    // 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    // 如果数组中不存在目标值 target，返回 [-1, -1]。
    // 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeftRange(nums, target);
        int right = searchRightRange(nums, target);
        if (left <= right) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    // 最左边的元素位置
    private int searchLeftRange(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int left = 0, right = n - 1;
        while (left <= right) { // 不一定存在，需要判断每一个元素，此处为 <=
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) { // 最左边元素的位置
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 最右边元素位置，即最左边较大元素位置减一
    private int searchRightRange(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target < nums[mid]) { // 最左边较大元素位置
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans - 1;
    }

}
