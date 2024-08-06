public class SortDemo {
    /**
     * 冒泡排序普通版
     *
     * @param arr 待排序的数组
     * @param len 数组中的元素个数
     */
    public static void bubbleSort(Integer[] arr, int len) {
        if (len <= 1) {
            return;
        }
        // 数组中有len个元素，进行len次冒泡
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序改良版
     *
     * @param arr 待排序的数组
     * @param len 数组中的元素个数
     */
    public static void betterBubbleSort(Integer[] arr, int len) {
        if (len <= 1) {
            return;
        }
        // 优化标识
        // 如果在某一次的冒泡过程中，没有位置交换说明已经排好序，直接break
        boolean flag = false;
        // 数组中有len个元素，进行len次冒泡
        for (int i = 0; i < len; i++) {
            // 如果有位置交换就重置标识为false
            flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            // 每次冒泡结束检查是否发生了数据交换
            // 如果没有发生数据交换，说明序列已经有序，不需要再继续冒泡了
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array 待排序的数组
     */
    public static int[] choiceSort(int[] array) {
        // 总共要经过N-1轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int min = 1;
            // 每轮需要比较的次数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j; // 记录目前能找到的最小值元素的下标
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array 待排序的数组
     */
    public static int[] insertSort(int[] array) {
        int j;
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            j = i;
            while (j > 0 && array[j - 1] > tmp) { // 从已经排序的序列最右边的开始比较，找到比其小的数
                array[j] = array[j - 1]; // 向后挪动
                j--;
            }
            array[j] = tmp; // 存在比其小的数，插入
        }
        return array;
    }
}
