public class MedianOfTwoSortedArrays {
    // 寻找两个正序数组的中位数
    // 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    // 算法的时间复杂度应该为 O(log (m+n)) 。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1) { // 总个数为奇数，取两个数组中间的数
            int mid = (len >> 1);
            return findNth(nums1, nums2, mid + 1);
        } else { // 总个数为偶数。取两个数组中间的两个数的平均值
            int mid1 = (len >> 1) - 1;
            int mid2 = (len >> 1);
            return (findNth(nums1, nums2, mid1 + 1) + findNth(nums1, nums2, mid2 + 1)) / 2.0;
        }
    }

    private double findNth(int[] nums1, int[] nums2, int n) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            if (idx1 == len1) {
                // nums1中全部淘汰，n位数在nums2中
                return nums2[idx2 + n - 1];
            }
            if (idx2 == len2) {
                // nums2中全部淘汰，n位数在nums1中
                return nums1[idx1 + n - 1];
            }
            if (n == 1) {
                // 在两个数组的头部中取
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            // 一次筛选一半，最后一个数组筛选完或者只筛选一个的时候，返回结果
            int midLen = (n >> 1); // midLen，一次筛选一半，确保要取出的第n个元素不会被淘汰，在一个数组里面，n位数在midLen右边
            // 执行筛选逻辑，一次筛选两个数组midLen的元素，不足全部淘汰
            int mid1 = Math.min(idx1 + midLen, len1) - 1; // 若淘汰，末尾元素的位置
            int mid2 = Math.min(idx2 + midLen, len2) - 1;
            if (nums1[mid1] < nums2[mid2]) {
                // nums1中元素被淘汰
                n -= (mid1 - idx1 + 1); // 总筛选个数减少
                idx1 = mid1 + 1; // 没有被筛选的第一个元素的位置2
            } else {
                // nums2中元素被淘汰
                n -= (mid2 - idx2 + 1);
                idx2 = mid2 + 1;
            }
        }
    }
}
