package simpleAlgorithm;

/**
 * @Author: WhaleFall541
 * @Date: 2021/6/12 16:43
 * [视频地址](https://www.bilibili.com/video/BV1Eb41147dK?t=1590)
 * 算法思维：先初始化堆（从最大的非叶子节点开始，往前不断进行树化成大根堆）
 * 再把头结点和最后一个节点互换位置，然后重新树化头结点，如此往复，每次排好一个
 * 元素最差的情况需要走(n-1)趟互换。
 *
 * 如何树化树化i节点成大根堆呢？
 *
 * 比较树化节点i和其叶子节点的大小，如果发现有比i节点还大的则互换位置
 * 然后去调整互换后的位置的节点直至到达叶子节点位置
 * PS：互换之后，MAX值所在的根堆被破坏 需要进一步调整
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 10, 3, 5, 1, 2};
        heapSort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println("sb = " + sb);
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        // 初始化堆 从最大的非叶子节点开始树化到头节点
        // last_node = n-1
        // 又 parent = (i-1)/2
        for (int i = (n - 2) / 2; i >= 0; i--)
            heapAdjust(arr, n, i);

        // 将大根堆中 根节点和最后一个节点互换位置
        for (int j = n - 1; j >= 0; j--) {
            swap(arr, j, 0);
            // 对剩下的堆 j个元素进行树化
            heapAdjust(arr, j, 0);
        }
    }

    /**
     * 对第i个节点所在的树进行树化,生成大根堆
     *
     * @param arr 需要树化的数组
     * @param n   树化时数的长度
     * @param i   当前树化的位置
     */
    private static void heapAdjust(int[] arr, int n, int i) {

        if (i >= n) return;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;
        if (left < n && arr[left] > arr[max])
            max = left;
        if (right < n && arr[right] > arr[max])
            max = right;
        if (max != i) {
            swap(arr, max, i);
            // 树化交换后max的位置,直到叶子节点或者没有交换情况为止
            heapAdjust(arr, n, max);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
