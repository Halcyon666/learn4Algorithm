package simpleAlgorithm;

import java.util.Arrays;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/10 22:42
 * @see <a href="https://www.bilibili.com/video/BV1nJ411V7bd?p=164">https://www.bilibili.com/video/BV1nJ411V7bd?p=164</a>
 *
 * 算法思想：选择一个中心点，将比中心点小的移动到左边，反之移动到右边；
 * 这时形成两个子序列，对子序列递归直至，每个序列只有一个元素为止；
 *
 * 为了省空间 设第一个元素为中心节点并存储该元素的值，从数组后面往前找一个
 * 比中心节点小的放在第一个元素的位置上，然后再从前面往后找找一个元素，放在
 * 后面空出来的元素的位置上。
 *
 * 当左右指针重合的时候，说明此时就是中心位置，故只需将最开始存储的第一个元素
 * 放到该位置即可
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 20, -3, -10, 100, -255};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {// 长度大于1
            int position = moveBaseOnPivot(arr, low, high);
            quickSort(arr, low, position - 1);
            quickSort(arr, position + 1, high);
        }
    }

    private static int moveBaseOnPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        // 当low 和high相同时，说明中心点就在这里可以回填pivot元素了
        while (low < high) {
            // NOTE: 条件别忘了 low < high
            // 当一直往前都没找到比pivot小的元素 从而造成数组越界
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
