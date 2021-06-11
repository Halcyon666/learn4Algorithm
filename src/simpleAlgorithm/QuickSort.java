package simpleAlgorithm;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/10 22:42
 * @see <a href="https://www.bilibili.com/video/BV1nJ411V7bd?p=164">https://www.bilibili.com/video/BV1nJ411V7bd?p=164</a>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 20, -3, -10, 100, -255};

        quickSort(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {// 长度大于1
            int position = moveBaseOnPivot(arr, low, high);
            quickSort(arr, low, position - 1);
            quickSort(arr, position + 1, high);
        }
    }

    private static int moveBaseOnPivot(int[] arr, int low, int high) {
        // {, 20, -3, -10, 100, -255};-1
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
