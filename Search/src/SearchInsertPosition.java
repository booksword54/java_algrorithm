public class SearchInsertPosition {
    // 搜索插入位置
    // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 请必须使用时间复杂度为 O(log n) 的算法。
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) { // 不一定在left和right中存在，每个位置都需要判断。此处为<=
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                ans = mid; // 第一个大于target的位置，最终会插入它的位置
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
