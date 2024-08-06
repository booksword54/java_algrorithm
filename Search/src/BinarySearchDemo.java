public class BinarySearchDemo {

    /**
     * 二分查找普通循环实现
     * 二分查找针对的是有序的数组
     *
     * @param nums   有序数组
     * @param target 查找元素
     */
    public static int binSearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // 取出首尾判断target是否在指定的nums中
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left] || target > nums[right]) {
            return -1;
        }
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[left]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @param srcArray 有序数组
     * @param start    数组低地址下标
     * @param end      数组高地址下标
     * @param key      查找元素
     * @return 查找元素不存在返回-1
     */
    public static int binSearch(int srcArray[], int start, int end, int key) {
        if (start >= end) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);
        if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return mid;
    }
}
