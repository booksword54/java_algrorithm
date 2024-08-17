public class ConvertSortedArrayToBinarySearchTree {
    // 将有序数组转换为二叉搜索树
    // 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left < right) { // 已到达子节点
            return null;
        }
        int mid = ((right - left) >> 1) + left;
        // nums是有序数组，按照中间元素划分左右子树，左右区间依然有序，可递归
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}

