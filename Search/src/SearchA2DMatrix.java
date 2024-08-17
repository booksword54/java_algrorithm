public class SearchA2DMatrix {
    // 搜索二维矩阵
    // 给你一个满足下述两条属性的 m x n 整数矩阵：
    // 每行中的整数从左到右按非严格递增顺序排列。
    // 每行的第一个整数大于前一行的最后一个整数。
    // 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low < high) { // target一定存在，最后搜索到的位置一定存在，此处使用 <
            int mid = ((high - low) >> 1) + low;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x > target) {
                high = mid; // 可能在mid的位置，此处 high = mid
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
