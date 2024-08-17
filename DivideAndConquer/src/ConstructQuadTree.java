import data_structure.Node;

public class ConstructQuadTree {
    // 建立四叉树
    // 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
    // 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
    // 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：

    // val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
    // isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。

    // 我们可以按以下步骤为二维区域构建四叉树：
    // 1、如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，
    // 将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
    // 2、如果当前网格的值不同，将 isLeaf 设为 False，
    // 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
    // 3、使用适当的子网格递归每个子节点。

    // 四叉树格式：
    // 你不需要阅读本节来解决这个问题。只有当你想了解输出格式时才会这样做。
    // 输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。

    // 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。

    // 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；
    // 如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。

    // 分治算法
    // 本题需要递归枚举正方形，直到正方形全是1或全是0为止。
    // 否则就切割成四个小正方形继续递归。
    // 判断全1或全0可以很容易想到，二维前缀和的结果是正方形的大小或0。
    private static final boolean IS_LEAF = true;
    private static final boolean IS_NOT_LEAF = false;
    private static final boolean ALL_ONE = true;
    private static final boolean RANDOM_VALUE = true;
    private static final boolean ALL_ZERO = false;
    private int[][] preSum; // 递归划分的前缀和数组

    public Node construct(int[][] grid) {
        int n = grid.length;
        preSum = new int[n + 1][n + 1]; // 以 i,j 结尾的正方形内数值之和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + grid[i][j];
            }
        }
        return dfs(0, 0, n, n);
    }

    private Node dfs(int x0, int y0, int x1, int y1) {
        // squareSum = rightBottom - rightTop - leftBottom + leftTop
        // squareSum是 (x0,y0)到(x1,y1)构成的正方形内的和
        int squareSum = preSum[x1][y1] - preSum[x1][y0] - preSum[x0][y1] + preSum[x0][y0];
        if (squareSum == 0) { // 全是0
            return new Node(ALL_ZERO, IS_LEAF);
        }
        if (squareSum == (x1 - x0) * (y1 - y0)) {
            return new Node(ALL_ONE, IS_LEAF);
        }
        int midX = (x0 + x1) / 2, midY = (y0 + y1) / 2;
        return new Node(RANDOM_VALUE, IS_NOT_LEAF,
                        dfs(x0, y0, midX, midY), // 递归计算四个子节点
                        dfs(x0, midY, midX, y1),
                        dfs(midX, y0, x1, midY),
                        dfs(midX, midY, x1, y1));
    }
}

